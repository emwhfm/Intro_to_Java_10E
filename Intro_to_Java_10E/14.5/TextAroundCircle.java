/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textaroundcircle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

/**
 *
 * @author emwhfm
 */
public class TextAroundCircle extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        final int r = 100;
        
        Pane pane = new Pane();
        pane.setPadding(new Insets(20));

        String myStr = "WELCOME TO JAVA ";
        double angle = 2 * Math.PI / myStr.length();
        Text text;
        for(int i=0; i<myStr.length(); i++) {
            text = new Text(200 + r * Math.cos(angle * i), 200 + r * Math.sin(angle * i), Character.toString(myStr.charAt(i)));
            text.setFont(Font.font("Times Roman", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 22));
            pane.getChildren().add(text);
        }
        
        Scene scene = new Scene(pane, 400, 400);
        
        primaryStage.setTitle("Chars around circle");
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
