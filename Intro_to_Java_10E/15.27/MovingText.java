/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package movingtext;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
//import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.util.Duration;
//import javafx.scene.shape.Line;

/**
 *
 * @author emwhfm
 */
public class MovingText extends Application {
    
    @Override
    public void start(Stage primaryStage) {
               
        Pane root = new Pane();
        
        Text text = new Text(0, 125, "Programming is fun");
        root.getChildren().add(text);
        
        //Line line = new Line (0, 125, 500, 125);
        //line.setStroke(Color.WHITE);
        //root.getChildren().add(line);
        
        EventHandler<ActionEvent> eventHandler = e -> {
            if (text.getX() > root.getWidth()) {
                text.setX(0);
            }
            else {
                text.setX(text.getX() + 5);
            }
        };
        
        /*PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(line);
        pt.setNode(text);
        pt.setOrientation(
        PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);
        
        pt.play(); // Start animation */
        
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation
        
        root.setOnMousePressed(e -> {
            if (animation.getStatus() == javafx.animation.Animation.Status.RUNNING) {
                    animation.pause();
            } 
        });
        
        root.setOnMouseReleased(e -> { 
            if (animation.getStatus() == javafx.animation.Animation.Status.PAUSED) {
                animation.play();
            }
        });

        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Moving text");
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
