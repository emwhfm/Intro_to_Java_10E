/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pendulum;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import javafx.scene.layout.Pane;

/**
 *
 * @author emwhfm
 */
public class PendulumPane extends Pane {
    
    private Timeline animation;
        
    private final double L = 170;
    private final double DT = 0.1;
        
    private double angle = Math.PI / 4;
    private double angleAccel = 0;
    private double angleVelocity = 0;
            
    Circle circle1;
    Line line;
    Circle circle2;
    
    public PendulumPane() {       
        final double R1 = 5;
        final double R2 = 10;
    
        circle1 = new Circle(0, 0, R1);
        circle1.setFill(Color.BLACK);
        getChildren().add(circle1);
        
        line = new Line(0, 0, 0, 0);
        line.setStroke(Color.BLACK);
        getChildren().add(line);
        
        circle2 = new Circle(0, 0, R2);
        circle2.setFill(Color.YELLOW);
        getChildren().add(circle2);
        
        this.setStyle("-fx-background-color: grey");
        
        animation = new Timeline(new KeyFrame(Duration.millis(DT * 1000), e -> movePendulum()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation
    }
  
    public void play() {
        animation.play();
    }
    
    public void pause() {
        animation.pause();
    }           
    
    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }
    
    public void decreaseSpeed() {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }
    
    protected void movePendulum() {        
        // Adjust pendulum position        
        angleAccel = -9.81 / L * Math.sin(angle);
        angleVelocity += angleAccel * DT;
        angle += angleVelocity * DT;
                
        double anchorX = this.getWidth() / 2;
        double anchorY = this.getHeight() / 4;
        
        double ballX = anchorX + (Math.sin(angle) * L);
        double ballY = anchorY + (Math.cos(angle) * L);
        
        circle1.setCenterX(anchorX);
        circle1.setCenterY(anchorY);
 
        line.setStartX(anchorX);
        line.setStartY(anchorY);        
        line.setEndX(ballX);
        line.setEndY(ballY);
        
        circle2.setCenterX(ballX);
        circle2.setCenterY(ballY);        
    }
}
        

