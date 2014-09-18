/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countclient;

import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class CountClient extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Socket socket;
        
        Label lb1 = new Label();
        StackPane root = new StackPane();
        root.getChildren().add(lb1);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Count client");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        try {
            // Create a socket to connect to the server
            socket = new Socket("localhost", 8000);

            // Create an input stream to receive data from the server
            DataInputStream fromServer = new DataInputStream(socket.getInputStream());     
            
            int clientNo = fromServer.readInt();
            lb1.setText("You are visitor " + clientNo);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }                          
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
