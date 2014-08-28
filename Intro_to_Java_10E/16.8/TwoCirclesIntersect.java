/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twocirclesintersect;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

/**
 *
 * @author emwhfm
 */
public class TwoCirclesIntersect extends Application {
    
    private CirclePane cp;
    private Label lb1;
    
    @Override
    public void start(Stage primaryStage) {
        
        lb1 = new Label("Two circles intersect?");
        
        cp = new CirclePane();
        
        Button btRedraw = new Button("Redraw Circles");
        
        BorderPane root = new BorderPane();
        root.setTop(lb1);
        BorderPane.setAlignment(lb1, Pos.CENTER);
        
        root.setCenter(cp);
        BorderPane.setAlignment(cp, Pos.CENTER);
        
        root.setBottom(btRedraw);
        BorderPane.setAlignment(btRedraw, Pos.CENTER);
        
        root.setPadding(new Insets(10));
        
        Scene scene = new Scene(root);
        
        btRedraw.setOnAction(e -> reDraw());
        
        /* new Thread(() -> { // lambda expression
            try {
                while (true) {                    
                    Platform.runLater(() -> checkIntersect()); // lambda exp
                    Thread.sleep(250);
                }
            }
            catch (InterruptedException ex) {
            }
        }).start(); */
        cp.getC1XProperty().addListener(ov -> {
            checkIntersect();
        });
        cp.getC1YProperty().addListener(ov -> {
            checkIntersect();
        });
        cp.getC1RProperty().addListener(ov -> {
            checkIntersect();
        });
        cp.getC2XProperty().addListener(ov -> {
            checkIntersect();
        });
        cp.getC2YProperty().addListener(ov -> {
            checkIntersect();
        });
        cp.getC2RProperty().addListener(ov -> {
            checkIntersect();
        });
        
        primaryStage.setTitle("Two circles intersect?");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    protected void reDraw() {
        cp.reDraw();
    }
    
    protected void checkIntersect() {
        if (cp.checkIntersects()) {
            lb1.setText("Two circles intersect? Yes");
        }
        else {
            lb1.setText("Two circles intersect? No");
        }    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
