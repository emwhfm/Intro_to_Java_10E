/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoe;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class TicTacToe {
    final static int SIZE = 3;
    
    public static void printBoard(char[][] grid) {
        System.out.println("——————-——————");
        for (int r=0; r<SIZE; r++) { 
            System.out.print("|");
            for (int k=0; k<SIZE; k++) {
                if (grid[r][k] == 'O') {
                    System.out.print(" O ");
                }
                else if (grid[r][k] == 'X') {
                    System.out.print(" X ");
                }
                else {
                    System.out.print("   ");  
                }
                System.out.print("|");
            }
            System.out.println("\n——————-——————");
        }
    }
    
    public static boolean getMove(char[][] grid, boolean odd) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a row (0, 1, or 2) for player ");
        if (odd) {
            System.out.print("X: ");
        }
        else {
            System.out.print("O: ");
        }
        int row = input.nextInt();
        
        System.out.print("Enter a column (0, 1, or 2) for player ");
         if (odd) {
            System.out.print("X:");
        }
        else {
            System.out.print("O:");
        }
        int col = input.nextInt();
        
        if (grid[row][col] != 'X' && grid[row][col] != 'O') {
            grid[row][col] = odd ? 'X' : 'O';
            return true;
        }
        else {
            return false;
        }            
    }
    
    public static boolean validateGrid(char[][] grid, String[] finalString) {
        //Check rows for winner
        for (int row=0; row<SIZE; row++) {
            if (grid[row][0] == 'X' &&  grid[row][1] == 'X' && grid[row][2] == 'X') {
                finalString[0] = "X player won";
                return true;
            }
            if (grid[row][0] == 'O' &&  grid[row][1] == 'O' && grid[row][2] == 'O') {          
                finalString[0] = "O player won";
                return true;
            }
        }
        
        // Check columns for winner
        for (int col=0; col<SIZE; col++) {
            if (grid[0][col] == 'X' &&  grid[1][col] == 'X' && grid[2][col] == 'X') {
                finalString[0] = "X player won";
                return true;
            }
            if (grid[0][col] == 'O' &&  grid[1][col] == 'O' && grid[2][col] == 'O') {
                finalString[0] = "O player won";
                return true;
            }
        }
        
        // Check diagonals
        if (grid[0][0] == 'X' &&  grid[1][1] == 'X' && grid[2][2] == 'X') {
            finalString[0] = "X player won";
            return true;
        }
        if (grid[0][2] == 'X' &&  grid[1][1] == 'X' && grid[2][0] == 'X') {
            finalString[0] = "X player won";
            return true;
        }
        if (grid[0][0] == 'O' &&  grid[1][1] == 'O' && grid[2][2] == 'O') {
            finalString[0] = "O player won";
            return true;
        }
        if (grid[0][2] == 'O' &&  grid[1][1] == 'O' && grid[2][0] == 'O') {
            finalString[0] = "O player won";
            return true;
        }
        
        //Check draw
        int count = 0;
        for (int row=0; row<SIZE; row++) {
            for (int col=0; col<SIZE; col++) {
                if (grid[row][col] == 'X' || grid[row][col] == 'O') {
                    count++;
                }
            }
        }
        if (count == SIZE*SIZE) {
            finalString[0] = "Draw";
            return true;  
        }        
        
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[][] grid = new char[SIZE][SIZE];
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
                System.out.println("Invalid move!!!");                 
            }
            printBoard(grid);
        }
        
        System.out.println(finalString[0]);
    }
    
}
