/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package displaygrid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

/**
 *
 * @author emwhfm
 */
public class DisplayGrid extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane pane = new Pane();
        
        // Vertical 1
        Line l1 = new Line(0, 0, 0, 0);
        l1.startXProperty().bind(pane.widthProperty().multiply(1.0/3.0));
        //l1.startYProperty().bind(r1.yProperty());
        l1.endXProperty().bind(l1.startXProperty());
        l1.endYProperty().bind(pane.heightProperty());
        l1.setStroke(Color.RED);
        pane.getChildren().add(l1);
        
        // Vertical 2
        Line l2 = new Line(0, 0, 0, 0);
        l2.startXProperty().bind(pane.widthProperty().multiply(2.0/3.0));
        //l1.startYProperty().bind(r1.yProperty());
        l2.endXProperty().bind(l2.startXProperty());
        l2.endYProperty().bind(pane.heightProperty());
        l2.setStroke(Color.RED);
        pane.getChildren().add(l2);        
        
        // Horisontal 1
        Line l3 = new Line(0, 0, 0, 0);
        //l3.startXProperty().bind(pane.widthProperty().multiply(1.0/3.0));
        l3.startYProperty().bind(pane.heightProperty().multiply(1.0/3.0));
        l3.endXProperty().bind(pane.widthProperty());
        l3.endYProperty().bind(l3.startYProperty());
        l3.setStroke(Color.BLUE);
        pane.getChildren().add(l3);
        
        // Horisontal 2
        Line l4 = new Line(0, 0, 0, 0);
        //l3.startXProperty().bind(pane.widthProperty().multiply(1.0/3.0));
        l4.startYProperty().bind(pane.heightProperty().multiply(2.0/3.0));
        l4.endXProperty().bind(pane.widthProperty());
        l4.endYProperty().bind(l4.startYProperty());
        l4.setStroke(Color.BLUE);
        pane.getChildren().add(l4);       
        
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("3x3 grid");
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
