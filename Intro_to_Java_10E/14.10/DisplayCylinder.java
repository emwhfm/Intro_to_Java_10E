/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package displaycylinder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class DisplayCylinder extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));
        
        Ellipse e1 = new Ellipse(50, 50, 40, 20);
        e1.setFill(Color.WHITE);
        e1.setStroke(Color.BLACK);
        pane.getChildren().add(e1);
        
        Line l1 = new Line(10, 50, 10, 150);
        l1.setStroke(Color.BLACK);
        pane.getChildren().add(l1);
        
        Line l2 = new Line(90, 50, 90,150);
        l2.setStroke(Color.BLACK);
        pane.getChildren().add(l2);
        
        Arc a1 = new Arc(50, 150, 40, 20, 0, -180);
        a1.setStroke(Color.BLACK);
        a1.setFill(Color.WHITE);
        a1.setType(ArcType.OPEN);
        pane.getChildren().add(a1);
        
        Arc a2 = new Arc(50, 150, 40, 20, 0, 180);
        a2.setStroke(Color.BLACK);
        a2.setFill(Color.WHITE);
        a2.setType(ArcType.OPEN);
        a2.getStrokeDashArray().addAll(6.0, 21.0);
        pane.getChildren().add(a2);
        
        Scene scene = new Scene(pane, 100, 200);
        
        primaryStage.setTitle("The cylinder");
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
