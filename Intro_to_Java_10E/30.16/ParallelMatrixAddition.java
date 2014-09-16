/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parallelmatrixaddition;

import java.util.concurrent.*;
import java.util.Arrays;

/**
 *
 * @author emwhfm
 */
public class ParallelMatrixAddition {
    
    private static final int SIZE = 2000;
    private static final int LOOPS = 100;
    
    private static final double[][] m1 = new double[SIZE][SIZE];
    private static final double[][] m2 = new double[SIZE][SIZE];
    private static double[][] m3; 
    private static double[][] m4; 
    
    private static long seq_total = 0;
    private static long par_total = 0;        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        
        // Init 
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                m1[r][c] = (Math.random() * 65535);
                m2[r][c] = (Math.random() * 65535);    
            }
        }
        
        // Exec tests
        for (int loop = 0; loop < LOOPS; loop++) {            
            doTests(loop);
        }
        
        // Summary
        System.out.println("=============================================");
        System.out.println("Summary");
        System.out.println("Sequential: " + seq_total / LOOPS + " ms");
        System.out.println("Parallel: " + par_total / LOOPS + " ms");
    }    
    
    private static void doTests(int loop) {
        System.out.println("=============================================");
        System.out.println("Loop: " + loop);
            
        System.gc();
        
        long startTime = System.currentTimeMillis();
        m3 = sequentialAddMatrix(m1, m2);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential time is " + 
                (endTime - startTime) + " ms");
        seq_total += (endTime - startTime);  
        
        System.gc();
                
        startTime = System.currentTimeMillis();
        m4 = parallelAddMatrix(m1, m2);        
        endTime = System.currentTimeMillis();
        System.out.println("Parallel time with "
            + Runtime.getRuntime().availableProcessors() +
            " processors is " + (endTime - startTime) + " ms");
        par_total += (endTime - startTime);                             
        
        if (Arrays.deepEquals(m3, m4)) {
            System.out.println("Results are equal");
        }
        else {
            System.out.println("Results are NOT equal");
            for (int row=0; row < SIZE; row++) {
                for (int col=0; col < SIZE; col++) {
                    System.out.print(m3[row][col]+ " ");
                    System.out.print(m4[row][col] + " ");
                }
                System.out.println();
            }
            System.exit(1);
        }
        
    }
    
    private static double[][] sequentialAddMatrix(double[][] a, double[][] b) {
        double[][] sum = new double[SIZE][SIZE]; 
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                sum[r][c] = a[r][c] + b[r][c];    
            }
        }
        return sum;
    }
        
    private static double[][] parallelAddMatrix(double[][] a, double[][] b) {
        double[][] c = new double[SIZE][SIZE]; 
        RecursiveAction mainTask = new AddTask(a, b, c, 0, SIZE - 1, 0, SIZE - 1);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
        return c;
    }
    
    private static class AddTask extends RecursiveAction {
        private final int THRESHOLD = SIZE / 2;
        private final double[][] a;
        private final double[][] b;
        private final double[][] c;
        private final int start_row;
        private final int stop_row;
        private final int start_col;
        private final int stop_col;
        
        AddTask(double[][] a, double[][] b, double[][] c, 
                int start_row, int stop_row,
                int start_col, int stop_col) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.start_row = start_row;
            this.stop_row = stop_row;
            this.start_col = start_col;
            this.stop_col = stop_col;
        }
        
        @Override
        protected void compute() {
            if (stop_row - start_row < THRESHOLD) {
                System.out.println("Hit rock bottom");
                for (int row = start_row; row <= stop_row; row++) {
                    for (int col = start_col; col <= stop_col; col++) {
                        c[row][col] = a[row][col] + b[row][col];
                    }
                }                
            }
            else {
                int mid_row = (start_row + stop_row) / 2;                
                invokeAll(new AddTask(a, b, c, start_row, mid_row, start_col, stop_col),
                        new AddTask(a, b, c, mid_row + 1, stop_row, start_col, stop_col));
            }
        }
                
    }
}
