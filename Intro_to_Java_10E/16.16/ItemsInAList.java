/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package itemsinalist;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;

/**
 *
 * @author emwhfm
 */
public class ItemsInAList extends Application {
    
    private ListView<String> lv;
    private Label lbList;    
        
    @Override
    public void start(Stage primaryStage) {
         
        final String[] modes = {"Single", "Multiple"};
        final String[] countries = {"China", "Japan", "Korea", "India", "Malaysia", "Vietnam"};
    
        // Top
        ComboBox<String> cbo = new ComboBox<>();        
        cbo.getItems().addAll(modes);
        cbo.setValue(modes[0]);
        
        ObservableList<String> items = FXCollections.observableArrayList(modes);
        cbo.setOnAction(e -> changeMode(items.indexOf(cbo.getValue())));
        
        HBox top = new HBox(20);
        top.getChildren().addAll(new Label("Choose Selection Mode:"), cbo);
        top.setAlignment(Pos.CENTER);
        
        // Center
        lv = new ListView<>(FXCollections.observableArrayList(countries));
        lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);       
        
        lv.getSelectionModel().selectedItemProperty().addListener(
            ov -> {                           
                StringBuilder tmpStr = new StringBuilder(); 
                for (Integer i : lv.getSelectionModel().getSelectedIndices()) {
                    tmpStr.append(countries[i]+ " ");
                }
                lbList.setText(tmpStr.toString());
            });
        
        ScrollPane sp = new ScrollPane(lv);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        
        // Bottom
        lbList = new Label("");
        
        HBox bottom = new HBox(20);
        bottom.getChildren().addAll(new Label("Selected items are:"), lbList);
        bottom.setAlignment(Pos.CENTER);
        
        // Container        
        BorderPane root = new BorderPane();
        root.setTop(top);
        root.setCenter(sp);        
        root.setBottom(bottom);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Items in a list");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    protected void changeMode(int index) {
        SelectionMode mode = index > 0 ? SelectionMode.MULTIPLE : SelectionMode.SINGLE;
        lv.getSelectionModel().setSelectionMode(mode);
        lv.getSelectionModel().clearSelection();
        lbList.setText("");        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
