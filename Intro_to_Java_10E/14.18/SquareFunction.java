/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package squarefunction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 *
 * @author emwhfm
 */
public class SquareFunction extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane pane = new Pane();       
        
        Polyline polyline = new Polyline();
        pane.getChildren().add(polyline);
        polyline.setStroke(Color.BLACK);
        ObservableList<Double> list = polyline.getPoints();
        final double scaleFactor = 0.0125;
        final double OFFSET_X = 200.0;
        final double OFFSET_Y= 200.0;
        for (int x = -100; x <= 100; x++) {
            list.add(OFFSET_X + x);
            list.add(OFFSET_Y - scaleFactor * x * x);
        }
        
        // Y axis
        Line l1 = new Line(200, 250, 200, 50);
        pane.getChildren().add(l1);
        
        Line l11 = new Line(190, 70, 200, 50);
        pane.getChildren().add(l11);
        
        Line l12 = new Line(210, 70, 200, 50);
        pane.getChildren().add(l12);
        
        Text t1 = new Text(220, 60, "Y");
        pane.getChildren().add(t1);
        
        // X axis
        Line l2 = new Line(50, 200, 350, 200);
        pane.getChildren().add(l2);
        
        Line l21 = new Line(330, 190, 350, 200);
        pane.getChildren().add(l21);
        
        Line l22 = new Line(330, 210, 350, 200);
        pane.getChildren().add(l22);
        
        Text t2 = new Text(340, 180, "X");
        pane.getChildren().add(t2);
        
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Square function");
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
