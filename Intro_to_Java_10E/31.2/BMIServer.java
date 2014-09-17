/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmiserver;

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class BMIServer extends Application {
    
    // Constants
    final double KILOGRAMS_PER_POUND = 0.45359237; 
    final double METERS_PER_INCH = 0.0254;
    
    ScrollPane sp;         
    
    @Override
    public void start(Stage primaryStage) {
        
        // Text area for displaying contents
        TextArea ta = new TextArea();
        sp = new ScrollPane(ta);     
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(sp, 450, 200);
        primaryStage.setTitle("BMI Server"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        new Thread(() -> {
            try {
                // Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() ->
                    ta.appendText("Server started at " + new Date() + '\n'));
                
                Platform.runLater(() ->
                    sp.setHvalue(0));
                
                // Listen for a connection request
                Socket socket = serverSocket.accept();
                
                Platform.runLater(() ->
                    ta.appendText("Connected to a client at " + new Date() + '\n'));

                // Create data input and output streams
                DataInputStream inputFromClient = new DataInputStream(
                    socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                    socket.getOutputStream());
                PrintWriter printWriter = new PrintWriter(outputToClient);

                while (true) {
                    // Receive weight and height from the client
                    double weight = inputFromClient.readDouble();
                    double height = inputFromClient.readDouble();
                    
                    Platform.runLater(() -> {
                        ta.appendText("Weight: " + weight + '\n');
                        ta.appendText("Height: " + height + '\n');
                    });
                    
                    // Compute BMI                                        
                    double weightInKilograms = weight * KILOGRAMS_PER_POUND;
                    double heightInMeters = height * METERS_PER_INCH;
                    
                    double bmi = (weightInKilograms /
                            (heightInMeters * heightInMeters));
                    double finalBMI = Math.round( bmi * 100.0 ) / 100.0;

                    // Analyze result
                    String descr;
                    if (finalBMI < 18.5)
                        descr = "Underweight";
                    else if (finalBMI < 25)
                        descr = "Normal";
                    else if (finalBMI < 30)
                        descr = "Overweight";
                    else
                        descr = "Obese";
                    
                    Platform.runLater(() -> {
                        ta.appendText("BMI is " + finalBMI + ". " + descr + '\n');                        
                    });
                    
                    // Send BMI back to the client
                    printWriter.print("BMI is " + finalBMI + ". " + descr + '\n');
                    printWriter.flush();                    
                }
            }
            catch(IOException ex) {
                ta.appendText(ex.toString() + '\n');
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
