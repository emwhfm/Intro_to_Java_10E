/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rectanguloid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;

/**
 *
 * @author emwhfm
 */
public class Rectanguloid extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));
        
        Rectangle r1 = new Rectangle(50, 10, 80, 80);
        r1.heightProperty().bind(pane.heightProperty().subtract(80));
        r1.widthProperty().bind(pane.widthProperty().subtract(80));
        r1.setFill(Color.TRANSPARENT);
        r1.setStroke(Color.BLACK);
        pane.getChildren().add(r1);
        
        Rectangle r2 = new Rectangle(40, 60, 80, 80);
        r2.heightProperty().bind(pane.heightProperty().subtract(80));
        r2.widthProperty().bind(pane.widthProperty().subtract(80));
        r2.setFill(Color.TRANSPARENT);
        r2.setStroke(Color.BLACK);
        pane.getChildren().add(r2);
        
        Line l1 = new Line();
        l1.startXProperty().bind(r1.xProperty());
        l1.startYProperty().bind(r1.yProperty());
        l1.endXProperty().bind(r2.xProperty());
        l1.endYProperty().bind(r2.yProperty());
        l1.setStroke(Color.BLACK);
        pane.getChildren().add(l1);
        
        Line l2 = new Line();
        l2.startXProperty().bind(r1.widthProperty().add(r1.getX()));
        l2.startYProperty().bind(r1.yProperty());
        l2.endXProperty().bind(r2.widthProperty().add(r2.getX()));
        l2.endYProperty().bind(r2.yProperty());
        l2.setStroke(Color.BLACK);
        pane.getChildren().add(l2);
        
        Line l3 = new Line();
        l3.startXProperty().bind(r1.xProperty());
        l3.startYProperty().bind(r1.heightProperty().add(r1.getY()));
        l3.endXProperty().bind(r2.xProperty());
        l3.endYProperty().bind(r2.heightProperty().add(r2.getY()));
        l3.setStroke(Color.BLACK);
        pane.getChildren().add(l3);
        
        Line l4 = new Line();
        l4.startXProperty().bind(r1.widthProperty().add(r1.getX()));
        l4.startYProperty().bind(r1.heightProperty().add(r1.getY()));
        l4.endXProperty().bind(r2.widthProperty().add(r2.getX()));
        l4.endYProperty().bind(r2.heightProperty().add(r2.getY()));
        l4.setStroke(Color.BLACK);
        pane.getChildren().add(l4);
        
        Scene scene = new Scene(pane, 200, 200);
        
        primaryStage.setTitle("Rectanguloid");
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
