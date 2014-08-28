/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package regularpolygon;

/**
 *
 * @author emwhfm
 */
public class RegularPolygon {

    private int n = 3;    // Number of sides
    private double side = 1; // Length of one side
    private double x = 0;
    private double y = 0;
    
    public RegularPolygon() {    
    }
    
    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
        x = 0;
        y = 0;
    }
    
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }
    
    public void setN(int n) {
        this.n = n;
    }
    
    public void setSide(double side) {
        this.side = side;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }    
    
    public int getN() {
        return n;
    }
    
    public double getSide() {
        return side;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getPerimeter() {
        return side * n;
    }
    
    public double getArea() {
        return n * Math.pow(side, 2) / 4 / Math.tan(Math.PI / n);
    }
    
}
