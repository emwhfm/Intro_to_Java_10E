/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class ConnectFour {

    final static int ROWS = 6;
    final static int COLUMNS = 7;
    
    public static void printBoard(char[][] grid) {        
        for (int r=0; r<ROWS; r++) { 
            System.out.print("|");
            for (int k=0; k<COLUMNS; k++) {
                if (grid[r][k] == 'R') {
                    System.out.print("R");
                }
                else if (grid[r][k] == 'Y') {
                    System.out.print("Y");
                }
                else {
                    System.out.print(" ");  
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("———————————————");
    } 
    
    public static boolean getMove(char[][] grid, boolean odd) {
        Scanner input = new Scanner(System.in);
        if (odd) {
            System.out.print("Drop a red disk at column (0–6): ");
        }
        else {
            System.out.print("Drop a yellow disk at column (0–6): ");
        }
        int col = input.nextInt();
        
        // Check column min/max
        if (col > COLUMNS - 1 || col < 0) {
            return false;
        } 
        
        // Check specified column full
        if (grid[0][col] == 'Y' || grid[0][col] == 'R') {
            return false;
        }
        
        // Check column empty
        if (grid[ROWS - 1][col] != 'Y' && grid[ROWS - 1][col] != 'R') {
            grid[ROWS - 1][col] = odd ? 'R' : 'Y'; 
            return true;
        } 
        
        // Find actual row in specified column
        for (int row=0; row<ROWS; row++) {
            if (grid[row][col] == 'Y' || grid[row][col] == 'R') {
                grid[row - 1][col] = odd ? 'R' : 'Y'; 
                break;
            }
        }   
    
        return true;
    }
    
    public static boolean validateVector(char[] vec, char ch) {
        int countInSequence = 0;
        
        for (int i=0; i<vec.length; i++) {
            if (vec[i] == ch) {
                countInSequence++;
            }
            else {
                countInSequence = 0;
            }
            if (countInSequence == 4) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean validateGrid(char[][] grid, String[] finalString) {
        //Check rows for winner
        for (int r=0; r<ROWS; r++) {
            if (validateVector(grid[r], 'R')) {
                finalString[0] = "The red player won";
                return true;
            }
            if (validateVector(grid[r], 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
            }
        }
        
        // Check columns for winner
        char[] tempRow = new char[ROWS];
        for (int c=0; c<COLUMNS; c++) {
            for (int r=0; r<ROWS; r++) {
                tempRow[r] = grid[r][c];
            }
            if (validateVector(tempRow, 'R')) {
                finalString[0] = "The red player won";
                return true;
            }
            if (validateVector(tempRow, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
            }
        }
        
        // Check diagonals
        // 1/12
        char[] tempDiag = new char[ROWS];
        for (int i=0; i<4; i++) {
            tempDiag[i] = grid[i+2][i];
        }
        if (validateVector(tempDiag, 'R')) {
                finalString[0] = "The red player won";
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
        }
        
        // 2/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<5; i++) {
            tempDiag[i] = grid[i+1][i];
        }
        if (validateVector(tempDiag, 'R')) {
                finalString[0] = "The red player won";
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
        }
        
        // 3/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<6; i++) {
            tempDiag[i] = grid[i][i];
        }
        if (validateVector(tempDiag, 'R')) {
                finalString[0] = "The red player won";
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
        }
        
        // 4/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<6; i++) {
            tempDiag[i] = grid[i][i+1];
        }
        if (validateVector(tempDiag, 'R')) {
                finalString[0] = "The red player won";
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
        }
        
        // 5/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<5; i++) {
            tempDiag[i] = grid[i][i+2];
        }
        if (validateVector(tempDiag, 'R')) {
                finalString[0] = "The red player won";
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
        }
        
        // 6/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<4; i++) {
            tempDiag[i] = grid[i][i+3];
        }
        if (validateVector(tempDiag, 'R')) {
                finalString[0] = "The red player won";
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
        }
        
        // 7/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<4; i++) {
            tempDiag[i] = grid[i][3-i];
        }
        if (validateVector(tempDiag, 'R')) {
                finalString[0] = "The red player won";
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
        }
        
        // 8/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<5; i++) {
            tempDiag[i] = grid[i][4-i];
        }
        if (validateVector(tempDiag, 'R')) {
                finalString[0] = "The red player won";
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
        }
        
        // 9/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<6; i++) {
            tempDiag[i] = grid[i][5-i];
        }
        if (validateVector(tempDiag, 'R')) {
                finalString[0] = "The red player won";
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
        }
        
        // 10/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<6; i++) {
            tempDiag[i] = grid[i][6-i];
        }
        if (validateVector(tempDiag, 'R')) {
                finalString[0] = "The red player won";
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
        }
        
        // 11/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<5; i++) {
            tempDiag[i] = grid[i+1][6-i];
        }
        if (validateVector(tempDiag, 'R')) {
                finalString[0] = "The red player won";
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
        }
        
        // 12/12
        java.util.Arrays.fill(tempDiag, '0');
        for (int i=0; i<4; i++) {
            tempDiag[i] = grid[i+2][6-i];
        }
        if (validateVector(tempDiag, 'R')) {
                finalString[0] = "The red player won";
                return true;
        }
        if (validateVector(tempDiag, 'Y')) {
                finalString[0] = "The yellow player won";
                return true;
        }
        
        // Check draw
        int count = 0;
        for (int row=0; row<ROWS; row++) {
            for (int col=0; col<COLUMNS; col++) {
                if (grid[row][col] == 'R' || grid[row][col] == 'Y') {
                    count++;
                }
            }
        }
        if (count == ROWS*COLUMNS) {
            finalString[0] = "Draw";
            return true;  
        }        
        
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[][] grid = new char[ROWS][COLUMNS];
        boolean endOfGame = false;
        boolean odd = true;
        String[] finalString = new String[1];
        
        printBoard(grid);

        while (!endOfGame) {
            if (getMove(grid, odd)) {
                endOfGame = validateGrid(grid, finalString);
                odd = !odd;               
            }
            else {
                System.out.println("Invalid column!!!");                 
            }
            printBoard(grid);
        }
        
        System.out.println(finalString[0]);
        
    }
    
}
