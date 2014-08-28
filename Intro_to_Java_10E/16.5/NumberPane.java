/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convertnumbers;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;

/**
 *
 * @author emwhfm
 */
public class NumberPane extends GridPane {

    private TextField tf1;
    private TextField tf2;
    private TextField tf3;
    
    NumberPane() {
        Label lb1 = new Label("Decimal");
        tf1 = new TextField();
        tf1.setAlignment(Pos.BASELINE_RIGHT);
        
        Label lb2 = new Label("Hex");
        tf2 = new TextField();
        tf2.setAlignment(Pos.BASELINE_RIGHT);
        
        Label lb3 = new Label("Binary");
        tf3 = new TextField();
        tf3.setAlignment(Pos.BASELINE_RIGHT);
        
        this.add(lb1, 0, 0);
        this.add(tf1, 1, 0);
        
        this.add(lb2, 0, 1);
        this.add(tf2, 1, 1);
        
        this.add(lb3, 0, 2);
        this.add(tf3, 1, 2);
        
        this.setAlignment(Pos.CENTER);
        
        this.setPadding(new Insets(10));
        this.setHgap(5);
        this.setVgap(5);
        
        tf1.setOnAction(e -> convFromDec());
        tf2.setOnAction(e -> convFromHex());
        tf3.setOnAction(e -> convFromBin());
    }
    
    protected void convFromDec() {
        Integer t1 = new Integer(tf1.getText());
        tf2.setText(Integer.toHexString(t1));
        tf3.setText(Integer.toBinaryString(t1));                
    }
    
    protected void convFromHex() {
        Integer t2 = Integer.parseInt(tf2.getText(), 16);        
        tf1.setText(Integer.toString(t2));
        tf3.setText(Integer.toBinaryString(t2));                
    }
    
    protected void convFromBin() {
        Integer t3 = Integer.parseInt(tf3.getText(), 2);  
        tf1.setText(Integer.toString(t3));
        tf2.setText(Integer.toHexString(t3));                
    }
}
