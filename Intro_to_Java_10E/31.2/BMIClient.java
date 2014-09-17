/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmiclient;

import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class BMIClient extends Application {
    
    TextArea ta = null;
    TextField tf1 = null;
    TextField tf2 = null;
    
    // IO streams
    DataOutputStream toServer = null;
    BufferedReader bufReader = null;

    @Override
    public void start(Stage primaryStage) {

        tf1 = new TextField();
        tf1.setEditable(true);
        tf1.setAlignment(Pos.BASELINE_RIGHT);
        
        tf2 = new TextField();
        tf2.setEditable(true);
        tf2.setAlignment(Pos.BASELINE_RIGHT);
        
        Button btSend = new Button("Send");
        
        btSend.setOnAction(e -> transceive());
                
        GridPane topPane = new GridPane();
        topPane.setAlignment(Pos.CENTER);
        topPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        topPane.setHgap(5.5);
        topPane.setVgap(5.5);
        
        topPane.add(new Label("Weight in pounds"), 0, 0);
        topPane.add(tf1, 1, 0);
        topPane.add(new Label("Height in inches"), 0, 1);
        topPane.add(tf2, 1, 1);        
        topPane.add(btSend, 2, 1);
        
        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(5, 5, 5, 5));

        ta = new TextArea();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(topPane);

        // Create a scene and place it in the stage
        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("BMI Client"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        connect();
    }
    
    private void connect() {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // Create an input stream to receive data from the server
            DataInputStream fromServer = new DataInputStream(socket.getInputStream());
            Reader reader = new InputStreamReader(fromServer);
            bufReader = new BufferedReader(reader);            
            
            // Create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException ex) {
            ta.appendText(ex.toString() + '\n');
        }        
    }
    
    private void transceive() {
        double weight = new Double(tf1.getText());
        double height = new Double(tf2.getText());
        
        ta.appendText("Weight: " + weight + '\n');
        ta.appendText("Height: " + height + '\n');
        
        try {
            toServer.writeDouble(weight);
            toServer.writeDouble(height);
            toServer.flush();
            
            String answer = bufReader.readLine();
            ta.appendText(answer + '\n');            
        }
        catch (IOException ex) {
            ta.appendText(ex.toString() + '\n');    
        }       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
