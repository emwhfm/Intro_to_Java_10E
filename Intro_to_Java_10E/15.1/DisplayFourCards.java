/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package displayfourcards;

import java.util.ArrayList;
import javafx.application.Application;
//import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;

/**
 *
 * @author emwhfm
 */
public class DisplayFourCards extends Application {
    
    private HBox pane;
            
    @Override
    public void start(Stage primaryStage) {
        pane = new HBox(10);
        pane.setPadding(new Insets(15, 15, 15, 15));
        pane.setStyle("-fx-background-color: gold");
        pane.setAlignment(Pos.CENTER);
        
        add2pane(pane);
        
        HBox pane2 = new HBox();
        pane2.setPadding(new Insets(15, 15, 15, 15));
        pane2.setStyle("-fx-background-color: gold");
        pane2.setAlignment(Pos.CENTER);
        
        Button btRefresh = new Button("Refresh");
        pane2.getChildren().add(btRefresh);
        
        // Create and register the handler
        btRefresh.setOnAction(new RefreshHandler());

        BorderPane border = new BorderPane();
        border.setCenter(pane);
        border.setBottom(pane2);
                        
        Scene scene = new Scene(border);
        
        primaryStage.setTitle("Four cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void add2pane(HBox pane) {
        ArrayList<Integer> myList = new ArrayList<>();
        for(int i=1; i<=52; i++) {
            myList.add(i);
        }
        java.util.Collections.shuffle(myList);        
        for(int i=0; i<4; i++) {
            pane.getChildren().add(new ImageView("card/" + myList.get(i) + ".png"));
        }
    }
    
    class RefreshHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            pane.getChildren().clear();
            add2pane(pane);
        }
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

}
