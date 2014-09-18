/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countserver;

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class CountServer extends Application {
    
    // Text area for displaying contents
    private TextArea ta = null;
    private ScrollPane sp = null;
    
    // Number a client
    private int clientNo = 0;
    // Numbar a connection
    private int threadNo = 0;

    @Override
    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
        ta = new TextArea();
        sp = new ScrollPane(ta);
        Scene scene = new Scene(sp, 450, 200);                        
        primaryStage.setTitle("Count server");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        new Thread( () -> {
            try {
                // Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);                
                Platform.runLater(() ->
                    ta.appendText("Server started at " + new Date() + '\n'));
                
                Platform.runLater(() ->
                    sp.setHvalue(0));
                
                RandomAccessFile inout = new RandomAccessFile("count.dat", "rw");                
                if (inout.length() != 0) {
                    clientNo = inout.readInt();    
                }
                                
                while (true) {
                    // Listen for a new connection request
                    Socket socket = serverSocket.accept();                    

                    Platform.runLater( () -> {
                        // Display the client number
                        ta.appendText("Starting thread " + threadNo++ + "\n");
                        // Find the client's host name, and IP address
                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("Client IP /" +
                            inetAddress.getHostAddress() + "\n");
                    });

                    // Increment clientNo
                    inout.seek(0);
                    inout.writeInt(++clientNo);
                    
                    // Create and start a new thread for the connection
                    new Thread(new HandleAClient(socket, clientNo)).start();
                }
            }
            catch(IOException ex) {
                System.err.println(ex);
            }
        }).start();        
    }

    // Define the thread class for handling new connection
    class HandleAClient implements Runnable {
        private final Socket socket; // A connected socket
        private final int clientNo; // A connection number
        
        /** Construct a thread */
        public HandleAClient(Socket socket, int clientNo) {
            this.socket = socket;
            this.clientNo = clientNo;
        }
        
        /** Run a thread */
        @Override
        public void run() {
            try {
                // Create data input and output streams
                DataOutputStream outputToClient = 
                        new DataOutputStream(socket.getOutputStream());
                
                // Send area back to the client
                outputToClient.writeInt(clientNo);
                outputToClient.flush();
            }
            catch(IOException ex) {
                System.err.println(ex);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
