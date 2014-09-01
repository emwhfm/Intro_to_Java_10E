/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colorselector;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
/**
 *
 * @author emwhfm
 */
public class ColorSelector extends Application {
    
    private Text txt;
    private Slider slRed;
    private Slider slGreen;
    private Slider slBlue;
    private Slider slOpacity;
    
    @Override
    public void start(Stage primaryStage) {

        txt = new Text("Show Colors");
        txt.setFont(Font.font("Times New Roman",
            FontWeight.BOLD, FontPosture.REGULAR, 20));

        slRed = new Slider(0.0, 100.0, 0.0);
        slRed.setShowTickLabels(true);
        slRed.setShowTickMarks(true);
        
        slGreen = new Slider(0.0, 100.0, 0.0);
        slGreen.setShowTickLabels(true);
        slGreen.setShowTickMarks(true);
        
        slBlue = new Slider(0.0, 100.0, 0.0);
        slBlue.setShowTickLabels(true);
        slBlue.setShowTickMarks(true);
        
        slOpacity = new Slider(0.0, 100.0, 100.0);
        slOpacity.setShowTickLabels(true);
        slOpacity.setShowTickMarks(true);
        
        VBox root = new VBox(20);
        root.getChildren().addAll(txt, slRed, slGreen, slBlue, slOpacity);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root);
        
        slRed.valueProperty().addListener(ov -> changeColor());                 
        slGreen.valueProperty().addListener(ov -> changeColor()); 
        slBlue.valueProperty().addListener(ov -> changeColor()); 
        slOpacity.valueProperty().addListener(ov -> changeColor()); 
        
        primaryStage.setTitle("Color selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    protected void changeColor() {
        Color c1 = new Color(slRed.getValue() / 100, 
            slGreen.getValue() / 100, slBlue.getValue() / 100, slOpacity.getValue() / 100);
        txt.setFill(c1);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
