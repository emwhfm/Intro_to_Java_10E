/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twocirclesintersect;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.beans.property.DoubleProperty;

/**
 *
 * @author emwhfm
 */
public class CirclePane extends BorderPane {
    
    private Pane center;
    private CircleInfo ci1;
    private CircleInfo ci2;
    
    private Circle c1;
    private Circle c2;   
    
    CirclePane() {        
        c1 = new Circle(0);
        c1.setStroke(Color.BLACK);
        c1.setFill(Color.TRANSPARENT);
        
        c2 = new Circle(0);    
        c2.setStroke(Color.BLACK);
        c2.setFill(Color.TRANSPARENT);
        
        center = new Pane();
        center.getChildren().addAll(c1, c2); 
        center.setPrefSize(200, 200);
        
        c1.setOnMouseDragged(e -> {
            c1.setCenterX(e.getX());
            c1.setCenterY(e.getY());
            ci1.setX(e.getX());
            ci1.setY(e.getY());
        });
        
        c2.setOnMouseDragged(e -> {
            c2.setCenterX(e.getX());
            c2.setCenterY(e.getY());
            ci2.setX(e.getX());
            ci2.setY(e.getY());
        }); 
        
        ci1 = new CircleInfo(1);
        ci2 = new CircleInfo(2);
        HBox bottom = new HBox(20);
        bottom.getChildren().addAll(ci1, ci2);
        
        bottom.setAlignment(Pos.CENTER);        
        
        this.setCenter(center);
        CirclePane.setAlignment(center, Pos.CENTER);
        
        this.setBottom(bottom);
        CirclePane.setAlignment(bottom, Pos.CENTER);
        
        this.setPadding(new Insets(10));
    }
    
    public void reDraw() {                
        //center.getChildren().clear();
        
        //c1 = new Circle(ci1.getX(), ci1.getY(), ci1.getR());
        c1.setCenterX(ci1.getX());
        c1.setCenterY(ci1.getY());
        c1.setRadius(ci1.getR());
        //c1.setStroke(Color.BLACK);
        //c1.setFill(Color.TRANSPARENT);
        
        //c2 = new Circle(ci2.getX(), ci2.getY(), ci2.getR());
        c2.setCenterX(ci2.getX());
        c2.setCenterY(ci2.getY());
        c2.setRadius(ci2.getR());
        //c2.setStroke(Color.BLACK);
        //c2.setFill(Color.TRANSPARENT);
        
        //center.getChildren().addAll(c1, c2);         
        
        /*c1.setOnMouseDragged(e -> {
            c1.setCenterX(e.getX());
            c1.setCenterY(e.getY());
            ci1.setX(e.getX());
            ci1.setY(e.getY());
        });
        
        c2.setOnMouseDragged(e -> {
            c2.setCenterX(e.getX());
            c2.setCenterY(e.getY());
            ci2.setX(e.getX());
            ci2.setY(e.getY());
        });*/ 
    }
    
    public boolean checkIntersects() {
        if (c1 != null && c2 != null) {
            return c1.intersects(c2.getBoundsInParent());
        }
        return false;
        
    }
    
    public DoubleProperty getC1XProperty() {
        return c1.centerXProperty();   
    }     
                
    public DoubleProperty getC1YProperty() {
        return c1.centerYProperty();
    }         

    public DoubleProperty getC1RProperty() {
        return c1.radiusProperty();
    }

    public DoubleProperty getC2XProperty() {
        return c2.centerXProperty();   
    }     
                
    public DoubleProperty getC2YProperty() {
        return c2.centerYProperty();
    }  
    
    public DoubleProperty getC2RProperty() {
        return c2.radiusProperty();
    }
}
