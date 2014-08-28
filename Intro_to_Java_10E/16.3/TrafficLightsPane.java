/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trafficlights;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author emwhfm
 */
public class TrafficLightsPane extends Pane {
    
    private Timeline animation;
    private Color color;
    
    private Circle c1;
    private Circle c2;
    private Circle c3;
    
    TrafficLightsPane() {
        repaint();    
        
        animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> changeLights()));
        animation.setCycleCount(Timeline.INDEFINITE);
        //animation.play(); // Start animation
    }
 
    public void setColor(Color color) {
        this.color = color;
        if (color == Color.RED) {
            c1.setFill(Color.RED);    
        }
        else if (color == Color.YELLOW) {
            c2.setFill(Color.YELLOW);  
        }
        else {
            c3.setFill(Color.GREEN); 
        }
    }
    
    public void play() {
        animation.play();
    }
 
    protected void changeLights() {                                
        repaint();
 
        if (color == Color.RED) {
            c1.setFill(Color.BLACK);
            c2.setFill(Color.YELLOW);
            color = Color.YELLOW;
        }
        else if (color == Color.YELLOW) {
            c2.setFill(Color.BLACK);
            c3.setFill(Color.GREEN);
            color = Color.GREEN;
        }
        else {
            c3.setFill(Color.BLACK);
            c1.setFill(Color.RED);
            color = Color.RED;    
        }
    }
    
    protected void repaint() {
        double w = this.getWidth() > 0 ? this.getWidth() : 300;
        double h = this.getHeight() > 0 ? this.getHeight() : 400;
                
        double r = h / 8 < w / 4 ? h / 8 : w / 4;
        
        this.getChildren().clear();
        
        c1 = new Circle(w / 2, h / 2 - 2 * r, r);
        c1.setStroke(Color.BLACK);        
        
        c2 = new Circle(w / 2, h / 2, r);
        c2.setStroke(Color.BLACK);
        
        c3 = new Circle(w / 2, h / 2 + 2 * r, r);
        c2.setStroke(Color.BLACK);
        
        Rectangle r1 = new Rectangle(w / 2 - r, h / 2 - 3 * r, 2 * r, 6 * r);
        r1.setStroke(Color.BLACK);
        r1.setFill(Color.TRANSPARENT);
        
        this.getChildren().addAll(c1, c2, c3, r1);
        
        if (animation != null) {
            if (animation.getStatus() == javafx.animation.Animation.Status.RUNNING) {
                this.setColor(this.color);
            }
        }
    }
}
