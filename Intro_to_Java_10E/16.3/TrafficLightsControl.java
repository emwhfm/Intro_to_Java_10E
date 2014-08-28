/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trafficlights;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

/**
 *
 * @author emwhfm
 */
public class TrafficLightsControl extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        TrafficLightsPane center = new TrafficLightsPane();
        
        center.widthProperty().addListener(ov ->
            center.repaint()
        );
        
        center.heightProperty().addListener(ov ->
            center.repaint()
        );
        
        HBox bottom = new HBox(20);
        bottom.setPadding(new Insets(5, 5, 5, 5));
        bottom.setStyle("-fx-border-width: 2px; -fx-border-color: black");
        bottom.setAlignment(Pos.CENTER);

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");

        bottom.getChildren().addAll(rbRed, rbYellow, rbGreen);
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                System.out.println("Red");
                center.setColor(Color.RED);
                center.play();
            }
        });
        
        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()) {
                System.out.println("Yellow");
                center.setColor(Color.YELLOW);
                center.play();
            }
        });
        
         rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                System.out.println("Green");
                center.setColor(Color.GREEN);
                center.play();
            }
        });                                                       
        
        BorderPane root = new BorderPane();
        root.setCenter(center);
        root.setBottom(bottom);
        
        Scene scene = new Scene(root, 300, 400);
        
        primaryStage.setTitle("Traffic Lights");
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
