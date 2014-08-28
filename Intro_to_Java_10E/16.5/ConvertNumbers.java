/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convertnumbers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class ConvertNumbers extends Application {
    
    @Override
    public void start(Stage primaryStage) {        
        
        NumberPane root = new NumberPane();        
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Convert numbers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
