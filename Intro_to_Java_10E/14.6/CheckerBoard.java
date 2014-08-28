/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package checkerboard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author emwhfm
 */
public class CheckerBoard extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    
        final double HEIGHT = 30;
        final double WIDTH = 30;
        
        Pane pane = new Pane();
        
        for(int row=0; row<8; row++) {
            for(int col=0; col<8; col++) {
                Rectangle rect = new Rectangle(row * WIDTH, col * HEIGHT, WIDTH, HEIGHT);
                if ((row + col) % 2 == 0) {
                    rect.setFill(Color.WHITE);
                }
                else {
                    rect.setFill(Color.BLACK);
                }
                pane.getChildren().add(rect);
            }             
        }
        
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Checkerboard");
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
