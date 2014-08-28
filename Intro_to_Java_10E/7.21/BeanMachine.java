/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beanmachine;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class BeanMachine {

    public static String getSimulatedPath(int numberOfSlots) {
        String path;
        path = "";
        char direction;
        for(int i=0; i<numberOfSlots-1; i++) {
            direction = ((int)(Math.random() * 10) > 4) ? 'R' : 'L';
            path += direction;
        }
        return path;
    }
    
    public static int getSlot(String path) {
        int count = 0;
        for (int i=0; i<path.length(); i++) {
            if (path.charAt(i) == 'R')
                count++;
        }
        return count;
    }
    
    public static int getMax(int[] slots) {
        int max = 0;
        for (int i=0; i<slots.length; i++) {
            if (slots[i] > max)
                max = slots[i];
        }
        return max;
    }
    
    public static void printHistogram(int[] slots) {
        // Find max frequency
        int max = getMax(slots);
        //System.out.println(max);
        
        // Print out
        for (int r=0; r<max; r++) {
            for (int k=0; k<slots.length; k++) {
                if (slots[k] >= max -r)
                    System.out.print('O');
                else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // User input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of balls to drop: ");
        int numberOfBalls = input.nextInt();
        System.out.print("Enter the number of slots in the bean machine: ");
        int numberOfSlots = input.nextInt();
        System.out.println();
        
        int[] slots = new int[numberOfSlots];
        // Mamin loop
        for (int i=0; i<numberOfBalls; i++) {
            String path =  getSimulatedPath(numberOfSlots);
            System.out.println(path);
            int slot = getSlot(path);
            slots[slot]++;
            //System.out.println(java.util.Arrays.toString(slots));
        }
        System.out.println();
        
        printHistogram(slots);       
    }
    
}
