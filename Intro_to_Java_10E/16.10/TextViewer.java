/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textviewer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class TextViewer extends Application {
    
    private TextField tfFile;
    private TextArea taFileContents;
    
    @Override
    public void start(Stage primaryStage) {     
        
        Label lb = new Label("Filename");
        lb.setContentDisplay(ContentDisplay.BOTTOM);
        
        tfFile = new TextField();
        tfFile.setAlignment(Pos.BASELINE_RIGHT);
        
        Button btView = new Button("View");
        
        btView.setOnAction(e -> displayFile());
        
        HBox bottom = new HBox(20);
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().addAll(lb, tfFile, btView);
        
        taFileContents = new TextArea();
        taFileContents.setWrapText(true);
        taFileContents.setEditable(false);
        ScrollPane scrollPane = new ScrollPane(taFileContents);
        
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(5, 5, 5, 5));
        root.setCenter(scrollPane);
        root.setBottom(bottom);
        
        Scene scene = new Scene(root);                
        
        primaryStage.setTitle("Text viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    protected void displayFile() {
        java.io.File file = new java.io.File(tfFile.getText());
        
        try {
            Scanner input = new Scanner(file);        
        
            taFileContents.clear();
            
            while (input.hasNext()) {
                String line = input.nextLine();
                taFileContents.appendText(line);
                taFileContents.appendText(System.getProperty("line.separator"));
            }
            input.close();
        }
        catch (java.io.IOException ex) {
            taFileContents.clear();
            taFileContents.setText("I/O Error: No such file");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
