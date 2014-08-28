/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pyramid;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class Pyramid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines [1-15] : ");
        int nr = input.nextInt();
        
        for (int r=1; r<=nr; r++) {
            // Print one row
            // 1. Print upto start of first number
            for (int z=0; z<=nr-r; z++) {
                System.out.print("    ");
            }
            // 2. Print number upto center '1'    
            for (int k=r; k>=1; k--) {
                System.out.printf("%4d", k);
            }
            // 3. Print number from center
            for (int p=2; p<=r; p++) {
                System.out.printf("%4d",p);
            }
            System.out.println();                
        }
        System.out.println();
        System.out.println();
        System.out.println();
    } 
    
}
