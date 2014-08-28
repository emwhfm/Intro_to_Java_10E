/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assigngrades;

import java.util.Scanner;

//import java.util.Arrays;

/**
 *
 * @author emwhfm
 */
public class AssignGrades {

    public static int findBest(int[] list) {
        int max = 0;
        for (int i=0; i<list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        return max;
    }
    
    public static char grade(int result, int max) {
        if (result >= max - 10) {
            return 'A';
        }
        else if (result >= max - 20) {
            return 'B';
        }
        else if (result >= max - 30) {
            return 'C';
        }
        else if (result >= max - 40) {
            return 'D';
        }
        else {
            return 'F';
        }
    }
    
    public static void printResult(int[] list, int max) {
        for (int i=0; i<list.length; i++) {
            System.out.println("Student " + i + " score is " + list[i] + " and grade is " + grade(list[i], max));
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // User input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int nr = input.nextInt();
        int[] list = new int[nr];
        System.out.print("Enter " + nr + " scores: ");
        for (int i=0; i<list.length; i++) {
            list[i] = input.nextInt();
        }
        //System.out.println(java.util.Arrays.toString(list));
        
        int best = findBest(list);
        //System.out.println("best = " + best);
        
        printResult(list, best);
    }
    
}
