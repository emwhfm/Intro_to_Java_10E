/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package displaythreecards;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author emwhfm
 */
public class DisplayThreeCards extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(15, 15, 15, 15));
        pane.setStyle("-fx-background-color: gold");
        
        add2pane(pane);
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Three cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void add2pane(HBox pane) {
        ArrayList<Integer> myList = new ArrayList<>();
        for(int i=1; i<=52; i++) {
            myList.add(i);
        }
        java.util.Collections.shuffle(myList);
        for(int i=0; i<3; i++) {
            pane.getChildren().add(new ImageView("card/" + myList.get(i) + ".png"));
        }
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
