/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

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
public class ChatServer extends Application {
    
    TextArea taServer = null;
    TextArea taClient = null;
    
    Socket socket = null;
    boolean clientConnected = false;
    BufferedReader bufReader = null;
    PrintWriter printWriter = null;
    StringBuilder stringBuilder = new StringBuilder();
    
    @Override
    public void start(Stage primaryStage) {
        
        // Server part at top
        taServer = new TextArea();
        VBox hbServer = new VBox();
        hbServer.getChildren().addAll(new Label("Server"), 
            new ScrollPane(taServer));

        // Client part at bottom
        taClient = new TextArea();
        taClient.setEditable(false);
        VBox hbClient = new VBox();
        hbClient.getChildren().addAll(new Label("Client"), 
            new ScrollPane(taClient));

        // The aggregated container
        VBox root = new VBox();
        root.getChildren().addAll(hbServer, hbClient);

        Scene scene = new Scene(root, 400, 250);

        primaryStage.setTitle("Chat server");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        taServer.setOnKeyPressed(e -> {
            if (clientConnected) {
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
                // Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);

                // Listen for a new connection request
                socket = serverSocket.accept();
                
                // Create an input stream to receive data from the client
                DataInputStream fromServer = new DataInputStream(socket.getInputStream());
                Reader reader = new InputStreamReader(fromServer);
                bufReader = new BufferedReader(reader); 
                
                // Create output stream to send data to the client
                DataOutputStream outputToClient = new DataOutputStream(
                    socket.getOutputStream());
                printWriter = new PrintWriter(outputToClient);
                clientConnected = true;                    
                
                while (true) {
                    String answer = bufReader.readLine();
                    Platform.runLater(() ->
                        taClient.appendText(answer + '\n'));                
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
