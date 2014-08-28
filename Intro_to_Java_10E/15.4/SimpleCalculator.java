/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simplecalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class SimpleCalculator extends Application {
    
    private final TextField tfNum1 = new TextField();
    private final TextField tfNum2 = new TextField();
    private final TextField tfRes  = new TextField();
    private final Button btAdd = new Button("Add");
    private final Button btSub = new Button("Subtract");
    private final Button btMul = new Button("Multiply");
    private final Button btDiv = new Button("Divide");
    
    @Override
    public void start(Stage primaryStage) {
        
        HBox top = new HBox(10);
        top.getChildren().add(new Label("Number1: "));
        top.getChildren().add(tfNum1);
        top.getChildren().add(new Label("Number2: "));
        top.getChildren().add(tfNum2);
        top.getChildren().add(new Label("Result: "));
        top.getChildren().add(tfRes);
        
        top.setPadding(new Insets(15, 15, 15, 15));
        //top.setStyle("-fx-background-color: gold");
        top.setAlignment(Pos.CENTER);
        tfRes.setEditable(false);
        tfNum1.setAlignment(Pos.CENTER_RIGHT);
        tfNum2.setAlignment(Pos.CENTER_RIGHT);
        tfRes.setAlignment(Pos.CENTER_RIGHT);
        
        // Process events
        btAdd.setOnAction(e -> add());
        btSub.setOnAction(e -> sub());
        btMul.setOnAction(e -> mul());
        btDiv.setOnAction(e -> div());        
        
        HBox bottom = new HBox(10);
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().add(btAdd);
        bottom.getChildren().add(btSub);
        bottom.getChildren().add(btMul);
        bottom.getChildren().add(btDiv);
        
        bottom.setPadding(new Insets(15, 15, 15, 15));
        //bottom.setStyle("-fx-background-color: gold");
        bottom.setAlignment(Pos.CENTER);
        
        BorderPane root = new BorderPane();
        root.setCenter(top);
        root.setBottom(bottom);
        
        root.setStyle("-fx-background-color: gold");
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Simple calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void add() {
        // Get values from text fields
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());

        tfRes.setText(String.format("%.1f", num1 + num2));
    }
    
    private void sub() {
        // Get values from text fields
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());

        tfRes.setText(String.format("%.1f", num1 - num2));
    }
    
    private void mul() {
        // Get values from text fields
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());

        tfRes.setText(String.format("%.1f", num1 * num2));
    }
    
    private void div() {
        // Get values from text fields
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());

        tfRes.setText(String.format("%.1f", num1 / num2));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
