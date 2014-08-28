/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isbn10;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class ISBN10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        int isbn = input.nextInt();
        
        // d 1 d 2 d 3 d 4 d 5 d 6 d 7 d 8 d 9 d 10 
        /*
            d10 = (d 1 * 1 + d 2 * 2 + d 3 * 3 + d 4 * 4 + d 5 * 5 +
                    d 6 * 6 + d 7 * 7 + d 8 * 8 + d 9 * 9) % 11 
        */
        int rest = isbn;
        int d9 = rest % 10;
        rest /= 10;
        
        int d8 = rest % 10;
        rest /= 10;
        
        int d7 = rest % 10;
        rest /= 10;
        
        int d6 = rest % 10;
        rest /= 10;
        
        int d5 = rest % 10;
        rest /= 10;
        
        int d4 = rest % 10;
        rest /= 10;
        
        int d3 = rest % 10;
        rest /= 10;
        
        int d2 = rest % 10;
        rest /= 10;
        
        int d1 = rest % 10;
        rest /= 10;
        
        int d10 = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 +
                    d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;
        
        System.out.print("The ISBN-10 number is " + d1 + d2 +d3 + d4 + d5 + d6 + d7 +d8 +d9);
        if (d10 == 10) {
            System.out.println("X");
        }
        else {
            System.out.println(d10);
        }
    }
    
}
