/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class ChatClient extends Application {
    
    TextArea taServer = null;
    TextArea taClient = null;
    
    boolean connectedToServer = false;
    BufferedReader bufReader = null;
    PrintWriter printWriter = null;
    StringBuilder stringBuilder = new StringBuilder();
    
    @Override
    public void start(Stage primaryStage) {
        
        // Server part at top
        taServer = new TextArea();
        taServer.setEditable(false);
        VBox hbServer = new VBox();
        hbServer.getChildren().addAll(new Label("Server"), 
            new ScrollPane(taServer));
        
        // Client part at bottom
        taClient = new TextArea();
        VBox hbClient = new VBox();
        hbClient.getChildren().addAll(new Label("Client"), 
            new ScrollPane(taClient));
        
        // The aggregated container
        VBox root = new VBox();
        root.getChildren().addAll(hbServer, hbClient);        
        
        Scene scene = new Scene(root, 400, 250);
        
        primaryStage.setTitle("Chat client");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        taClient.setOnKeyPressed(e -> {
            if (connectedToServer) {                
                if (e.getCode() == KeyCode.ENTER) {
                    printWriter.print(stringBuilder.toString() + '\n');
                    printWriter.flush();                    
                    stringBuilder.delete(0, stringBuilder.length());
                }     
                else if (e.getCode() == KeyCode.BACK_SPACE) {
                    stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());    
                }
                else {
                    stringBuilder.append(e.getText());
                }
            }
        });
        
        new Thread( () -> {
            try {
                // Create a socket to connect to the server
                Socket socket = new Socket("localhost", 8000);

                // Create an input stream to receive data from the server
                DataInputStream fromServer = new DataInputStream(socket.getInputStream());
                Reader reader = new InputStreamReader(fromServer);
                bufReader = new BufferedReader(reader); 
                
                // Create output stream to send data to the server
                DataOutputStream outputToServer = new DataOutputStream(
                    socket.getOutputStream());
                printWriter = new PrintWriter(outputToServer);
                
                connectedToServer = true;
            
                while (true) {
                    String answer = bufReader.readLine();                    
                    Platform.runLater(() ->
                        taServer.appendText(answer + '\n'));                
                }
            }
            catch(IOException ex) {
                System.err.println(ex);
            }
        }).start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
