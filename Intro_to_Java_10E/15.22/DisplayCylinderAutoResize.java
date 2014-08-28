/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package displaycylinderautoresize;

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
public class DisplayCylinderAutoResize extends Application {
    
    private Pane pane;
    
    @Override
    public void start(Stage primaryStage) {
        
        pane = new Pane();
        pane.setPadding(new Insets(10));
        
        add2pane();              
        
        pane.widthProperty().addListener(ov ->
            this.add2pane()
        );
        
        pane.heightProperty().addListener(ov ->
            this.add2pane()
        );
        
        Scene scene = new Scene(pane, 100, 200);
        
        primaryStage.setTitle("The cylinder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    private void add2pane() {
        pane.getChildren().clear();
        
        double h = pane.getHeight();
        double w = pane.getWidth();
        double center_x = w / 2;
        double center_y = h / 2;
        double from_top_x = 20;
                        
        Ellipse e1 = new Ellipse(center_x, w / 4, w / 2, w / 4);
        e1.setFill(Color.WHITE);
        e1.setStroke(Color.BLACK);
        pane.getChildren().add(e1);
        
        Line l1 = new Line(0, w / 4, 0, h - w / 4);
        l1.setStroke(Color.BLACK);
        pane.getChildren().add(l1);
        
        Line l2 = new Line(w, w / 4, w, h - w / 4);
        l2.setStroke(Color.BLACK);
        pane.getChildren().add(l2);
        
        Arc a1 = new Arc(center_x, h - w / 4, w / 2, w / 4, 0, -180);
        a1.setStroke(Color.BLACK);
        a1.setFill(Color.WHITE);
        a1.setType(ArcType.OPEN);
        pane.getChildren().add(a1);
        
        Arc a2 = new Arc(center_x, h - w / 4, w / 2, w / 4, 0, 180);
        a2.setStroke(Color.BLACK);
        a2.setFill(Color.WHITE);
        a2.setType(ArcType.OPEN);
        a2.getStrokeDashArray().addAll(6.0, 21.0);
        pane.getChildren().add(a2);    
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
