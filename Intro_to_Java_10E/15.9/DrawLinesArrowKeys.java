/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package drawlinesarrowkeys;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

/**
 *
 * @author emwhfm
 */
public class DrawLinesArrowKeys extends Application {
    
    private double x = 150;
    private double y = 150;
    private double dx = 10;
    private double dy = 10;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        //root.getChildren().add(btn);
        root.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN: 
                    Line line1 = new Line(x, y, x, y + dy);                   
                    root.getChildren().add(line1);
                    y += dy;
                    break;
                case UP: 
                    Line line2 = new Line(x, y, x, y - dy);
                    root.getChildren().add(line2);
                    y -= dy;
                    break;
                case LEFT: 
                    Line line3 = new Line(x, y, x - dx, y);
                    root.getChildren().add(line3);
                    x -= dx;
                    break;
                case RIGHT:
                    Line line4 = new Line(x, y, x + dx, y);
                    root.getChildren().add(line4);
                    x += dx;
                    break;
                default:
            }
        });
        
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("Draw lines using arrow keys");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        root.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
