/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package displayzeroone;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class DisplayZeroOne extends Application {
    
    @Override
    public void start(Stage primaryStage) {
                
        GridPane pane = new GridPane();
        
        for(int col=0; col<10; col++) {
            for (int row=0; row<10; row++) {
                String num = Math.random() > 0.5 ? "1" : "0";                                
                TextField tf = new TextField(num);
                tf.setAlignment(Pos.CENTER);
                tf.setEditable(false);
                tf.setPrefWidth(40);
                pane.add(tf, col, row);
            }
        }
        
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Zero or One");
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
