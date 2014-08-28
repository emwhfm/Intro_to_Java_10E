/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colorandfont;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class ColorAndFont extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(20);
        pane.setPadding(new Insets(15, 15, 15, 15));
        //pane.setStyle("-fx-background-color: green");
        
        Text text;
        for(int i=0; i<5; i++) {
            text = new Text("Java");
            text.setFont(Font.font("Times Roman",
                            FontWeight.BOLD, FontPosture.ITALIC, 22));
            text.setRotate(90);
            text.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
            pane.getChildren().add(text);
        }
        
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Color and Font");
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
