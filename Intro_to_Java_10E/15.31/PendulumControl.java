/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pendulum;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

/**
 *
 * @author emwhfm
 */
public class PendulumControl extends Application {
    
    @Override
    public void start(Stage primaryStage) {      
        
        PendulumPane pendulumPane = new PendulumPane();
                
        pendulumPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                pendulumPane.increaseSpeed();
            }
            else if (e.getCode() == KeyCode.DOWN) {
                pendulumPane.decreaseSpeed();
            }
            else if (e.getCode() == KeyCode.S) {
                pendulumPane.pause();
            }
            else if (e.getCode() == KeyCode.R) {
                pendulumPane.play();
            }
        });
        
        Scene scene = new Scene(pendulumPane, 400, 250);
        
        primaryStage.setTitle("Pendulum");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pendulumPane.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
