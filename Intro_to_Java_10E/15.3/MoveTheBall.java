/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package movetheball;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;

/**
 *
 * @author emwhfm
 */
public class MoveTheBall extends Application {
    
    private BallPane ballPane = new BallPane();
    
    @Override
    public void start(Stage primaryStage) {                
        
        HBox pane2 = new HBox(20);
        pane2.setAlignment(Pos.CENTER);
        
        Button btLeft = new Button("Left");
        btLeft.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ballPane.moveLeft();
            }
        });
        
        Button btRight = new Button("Right");
        btRight.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ballPane.moveRight();
            }
        });
        
        Button btUp = new Button("Up");
        btUp.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ballPane.moveUp();
            }
        });
        
        Button btDown = new Button("Down");
        btDown.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ballPane.moveDown();
            }
        });
        
        pane2.getChildren().addAll(btLeft, btRight, btUp, btDown);
        
        BorderPane border = new BorderPane();
        border.setCenter(ballPane);
        border.setBottom(pane2);
        BorderPane.setAlignment(pane2, Pos.CENTER);
        
        Scene scene = new Scene(border, 300, 300);
        
        primaryStage.setTitle("Move the ball");
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

class BallPane extends Pane {
    
    private final double RADIUS = 50;
    
    private Circle circle = new Circle(150, 150, RADIUS);

    public BallPane() {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.MAGENTA);
    }
    
    public void moveLeft() {
        if (circle.getCenterX() - RADIUS > 0) {
            circle.setCenterX(circle.getCenterX() - 5);       
        }
    }

    public void moveRight() {
        if (circle.getCenterX() + RADIUS < 300) {
            circle.setCenterX(circle.getCenterX() + 5);
        }
    }
    
    public void moveUp() {
        if (circle.getCenterY() - RADIUS > 0) {
            circle.setCenterY(circle.getCenterY() - 5);    
        }
    }
    
    public void moveDown() {
        if (circle.getCenterY() + RADIUS < 300) {
            circle.setCenterY(circle.getCenterY() + 5); 
        }
    }
}
    
