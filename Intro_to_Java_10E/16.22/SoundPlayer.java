/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package soundplayer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

import java.io.File;

/**
 *
 * @author emwhfm
 */
public class SoundPlayer extends Application {
    
    @Override
    public void start(Stage primaryStage) {
                
        AudioClip ac = new AudioClip(new File("sound/piano2.wav").toURI().toString());
        
        Button btPlay = new Button("Play");
        Button btLoop = new Button("Loop");
        Button btStop = new Button("Stop");
                
        HBox root = new HBox(20);
        root.getChildren().addAll(btPlay, btLoop, btStop);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root);
        
        btPlay.setOnAction(e -> {
            ac.setCycleCount(1);
            ac.play();
        });
        
        btLoop.setOnAction(e -> {
            ac.setCycleCount(AudioClip.INDEFINITE);
            ac.play();
        });

        btStop.setOnAction(e -> {
            ac.stop();
        });

        
        primaryStage.setTitle("Sound player");
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
