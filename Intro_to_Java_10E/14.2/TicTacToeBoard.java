/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoeboard;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author emwhfm
 */
public class TicTacToeBoard extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane(); 
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20));
        pane.setHgap(5);
        pane.setVgap(5);

        add2pane(pane);
        
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Tic-tac-toe board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void add2pane(GridPane pane) {        
        for (int col=0; col<3; col++) {
            for (int row=0; row<3; row++) {
                int rnd = (int)(Math.random() * 3);
                if (rnd == 0) {
                    pane.add(new ImageView("image/o.gif"), col, row);                        
                }
                else if (rnd == 1) {
                    pane.add(new ImageView("image/x.gif"), col, row);
                }                
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
