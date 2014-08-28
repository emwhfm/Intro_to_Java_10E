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
public class TestRegularPolygon {
    
    private static void printPolygon(RegularPolygon p) {
        System.out.println("Perimeter = " + p.getPerimeter());
        System.out.println("Area = " + p.getArea());        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RegularPolygon p1 = new RegularPolygon();
        printPolygon(p1);
        
        RegularPolygon p2 = new RegularPolygon(6, 4);
        printPolygon(p2);
        
        RegularPolygon p3 = new RegularPolygon(10, 4, 5.6, 7.8);
        printPolygon(p3);
        
    }
}
