/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quadraticequation;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class QuadraticEquation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final double EPSILON = 1E-14;
        Scanner input = new Scanner(System.in);
        double root1;
        double root2;
        
        System.out.println("ax2 + bx + c = 0");
        System.out.print("Enter a b c : ");        
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        
        double discr = Math.pow(b,2) - 4 * a * c; 
        if (Math.abs(discr) < EPSILON) {
            root1 = -b / (2 * a);
            System.out.println("The equation has one root : " + root1);
        }
        else if (discr > 0) {
            root1 = (-b + Math.pow(discr, 0.5)) / ( 2 * a);
            root2 = (-b - Math.pow(discr, 0.5)) / ( 2 * a);
            System.out.println("The equation has two roots : " + root1 + " and " + root2);
        }
        else {
            System.out.println("The equation has no real roots");   
        }
    }
    
}
