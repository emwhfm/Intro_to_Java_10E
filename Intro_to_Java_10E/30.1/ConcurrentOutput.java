/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package concurrentoutput;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class ConcurrentOutput extends Application {
    
    private TextArea ta1;
    
    @Override
    public void start(Stage primaryStage) {       
        
        ta1 = new TextArea();
        ta1.setEditable(false);
        ta1.setWrapText(true);
        
        StackPane root = new StackPane();
        root.getChildren().add(ta1);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Concurrent output");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        manage_threads();
    }
    
    private void manage_threads() {
        // Create tasks
        PrintChar printA = new PrintChar(ta1, 200, 'a', 100);
        PrintChar printB = new PrintChar(ta1, 10, 'b', 100);
        PrintNum print100 = new PrintNum(ta1, 50, 100);
        
        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        
        thread1.setPriority(Thread.NORM_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.NORM_PRIORITY);
        
        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
