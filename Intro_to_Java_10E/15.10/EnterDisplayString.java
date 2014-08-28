/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterdisplaystring;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.input.KeyCode;

/**
 *
 * @author emwhfm
 */
public class EnterDisplayString extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Text text = new Text("");
        StringBuilder myStr = new StringBuilder();
        StackPane root = new StackPane();
        root.getChildren().add(text);
        
        root.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                text.setText(myStr.toString());
                myStr.delete(0, myStr.length());
            } 
            else if (Character.isLetterOrDigit(e.getText().charAt(0))) {
                myStr.append(e.getText().charAt(0));
            }      
        });
        
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("Enter display string");
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
