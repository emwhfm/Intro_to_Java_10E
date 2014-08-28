/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matrixmultiply;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class MatrixMultiply {

    final static int SIZE = 3;
    
    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        double[][] c = new double[SIZE][SIZE];
        /*double[][] c = { {1, 2, 3},
                         {1, 2, 3},
                         {1, 2, 3} }; */
        for (int r=0; r<SIZE; r++) {
            for (int k=0; k<SIZE; k++) {
                c[r][k] = a[r][0] * b[0][k] + a[r][1] * b[1][k] + a[r][2] * b[2][k];
            }
        }
        
        return c;
    }
    
    public static void printMatrices(double[][] a, double[][] b, double[][] c) {
        for (int r=0; r<SIZE; r++) {
            // Print A columns
            for (int k=0; k<SIZE; k++) {
                System.out.printf("%6.1f", a[r][k]);
            }
            // Print space
            if (r != 1) {
                System.out.print("   ");
            } 
            else {
                System.out.print(" * ");
            }
            // Print B columns
            for (int k=0; k<SIZE; k++) {
                System.out.printf("%6.1f", b[r][k]);
            }
            // Print space
            if (r != 1) {
                System.out.print("   ");
            } 
            else {
                System.out.print(" = ");
            }
            // Print C columns
            for (int k=0; k<SIZE; k++) {
                System.out.printf("%6.1f", c[r][k]);
            }
            System.out.println();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] a = new double[SIZE][SIZE];
        double[][] b = new double[SIZE][SIZE];
        double[][] c;
        
        System.out.print("Enter matrix1: ");
        for (int r=0; r<SIZE; r++) {
            for (int k=0; k<SIZE; k++) {
                a[r][k] = input.nextDouble();
            }
        }
        
        System.out.print("Enter matrix2: ");
        for (int r=0; r<SIZE; r++) {
            for (int k=0; k<SIZE; k++) {
                b[r][k] = input.nextDouble();
            }
        }
        
        c = multiplyMatrix(a, b);
        
        printMatrices(a, b, c);
    }
    
}
