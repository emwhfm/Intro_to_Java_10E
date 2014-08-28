/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sineandcosine;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author emwhfm
 */
public class SineAndCosine extends Application {

    private PathTransition pt1;
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane pane = new Pane();
        
        Polyline polyline1 = new Polyline();
        Polyline polyline2 = new Polyline();
        pane.getChildren().addAll(polyline1, polyline2);
        
        polyline1.setStroke(Color.RED);
        polyline2.setStroke(Color.BLUE);
        
        ObservableList<Double> list1 = polyline1.getPoints();
        ObservableList<Double> list2 = polyline2.getPoints();        
        
        final double SCALEFACTOR = 80;
        final double OFFSET_X = 700.0;
        final double OFFSET_Y = 100.0;
        
        for (int x = -630; x <= 630; x+=2) {
            list1.add(OFFSET_X + x);
            list2.add(OFFSET_X + x);            
            list1.add(OFFSET_Y - SCALEFACTOR * Math.sin(x * Math.PI / 180.0));
            list2.add(OFFSET_Y - SCALEFACTOR * Math.cos(x * Math.PI / 180.0));            
        }                
        
        // Create two circles
        Circle circle1 = new Circle(125, 100, 10);
        circle1.setFill(Color.BEIGE);
        circle1.setStroke(Color.BLACK);
        pane.getChildren().add(circle1);

        Circle circle2 = new Circle(125, 100, 10);
        circle2.setFill(Color.ORANGE);
        circle2.setStroke(Color.BLACK);
        pane.getChildren().add(circle2);
        
        // Create two path transitions
        pt1 = new PathTransition();
        pt1.setDuration(Duration.millis(4000));
        pt1.setPath(polyline1);
        pt1.setNode(circle1);
        pt1.setOrientation(
        PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt1.setCycleCount(Timeline.INDEFINITE);
        pt1.setAutoReverse(false);
        
        PathTransition pt2 = new PathTransition();
        pt2.setDuration(Duration.millis(2000));
        pt2.setPath(polyline2);
        pt2.setNode(circle2);
        pt2.setOrientation(
        PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt2.setCycleCount(Timeline.INDEFINITE);
        pt2.setAutoReverse(false);
        
        pt1.play(); // Start animation
        pt2.play(); // Start animation
        
        pane.setOnMousePressed(e -> {
            //System.out.println("Click!");
            if (e.getButton() == MouseButton.PRIMARY) {
                if (pt1.getStatus() == javafx.animation.Animation.Status.RUNNING) {
                    pt1.pause();
                    pt2.pause();
                }
            }
            if (e.getButton() == MouseButton.SECONDARY) {
                if (pt1.getStatus() == javafx.animation.Animation.Status.PAUSED) {
                    pt1.play();
                    pt2.play();
                }
            }
        });
        
        /*pane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                //if (pt1.getStatus() == javafx.animation.Animation.Status.PAUSED) {
                    pt1.play();
                    pt2.play();
                //}
            }
        });*/

        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Sine and cosine");
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
