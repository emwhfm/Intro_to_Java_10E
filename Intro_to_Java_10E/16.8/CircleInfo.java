/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twocirclesintersect;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author emwhfm
 */
public class CircleInfo extends GridPane {
    
    private int id;  
    private TextField tfX;
    private TextField tfY;
    private TextField tfR;
    
    CircleInfo(int id) {
        this.id = id;
        
        Label lb1 = new Label("Enter circle " + id + " info:");
        Label lb2 = new Label("Center x:");
        Label lb3 = new Label("Center y:");
        Label lb4 = new Label("Radius:");                
        
        tfX = new TextField("0");
        tfY = new TextField("0");
        tfR = new TextField("0");
        
        tfX.setAlignment(Pos.BOTTOM_RIGHT);
        tfX.setPrefColumnCount(5);
        tfY.setAlignment(Pos.BOTTOM_RIGHT);
        tfY.setPrefColumnCount(5);
        tfR.setAlignment(Pos.BOTTOM_RIGHT);
        tfR.setPrefColumnCount(5);
        
        this.add(lb1, 0, 0);
        this.add(lb2, 0, 1);
        this.add(tfX, 1, 1);
        this.add(lb3, 0, 2);
        this.add(tfY, 1, 2);
        this.add(lb4, 0, 3);
        this.add(tfR, 1, 3);   
        
        this.setPadding(new Insets(10));
        this.setStyle("-fx-border-style: solid; -fx-border-color: black; -fx-border-width: 2px;");  
        CircleInfo.setColumnSpan(lb1, 2);
    }

    public double getX() {
        return Double.parseDouble(tfX.getText());      
    }

    public double getY() {
        return Double.parseDouble(tfY.getText());
    }

    public double getR() {
        return Double.parseDouble(tfR.getText());
    }
    
    public void setX(double x) {
        tfX.setText(Double.toString(x));
    }
    
    public void setY(double y) {
        tfY.setText(Double.toString(y));
    }
    
}
