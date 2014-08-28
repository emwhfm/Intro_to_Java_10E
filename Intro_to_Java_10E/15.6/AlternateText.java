/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alternatetext;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class AlternateText extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Text text = new Text("Java is fun");
        StackPane root = new StackPane();
        root.getChildren().add(text);
        
        root.setOnMouseClicked(e -> {
            if (text.getText().endsWith("fun"))
                text.setText("Java is powerful");
            else
                text.setText("Java is fun");
        });
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Alternate text");
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
