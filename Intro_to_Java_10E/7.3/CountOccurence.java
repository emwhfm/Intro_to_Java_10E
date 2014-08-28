/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package countoccurence;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class CountOccurence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] list = new int[100];
        
        System.out.print("Enter the integers between 1 and 100: ");
        while (true) {
            int digit = input.nextInt();
            if (digit == 0) break;
            list[digit-1]++;
        }
        
        for (int i=0; i<list.length; i++) {
            if (list[i] != 0) {
                System.out.print((i+1) + " occurs " + list[i]);
                if (list[i] == 1)
                    System.out.println(" time");
                else
                    System.out.println(" times");
            }
        }
    }
    
}
