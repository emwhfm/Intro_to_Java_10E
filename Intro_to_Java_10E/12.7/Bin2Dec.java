/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bin2dec;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class Bin2Dec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        // Prompt the user to enter a string
        System.out.print("Enter a bin number: ");
        String bin = input.nextLine();
        try {
            System.out.println("The decimal value for bin number "
                + bin + " is " + binToDecimal(bin));
        }
        catch (NumberFormatException ex) {            
            System.out.println(ex.getMessage());
            System.out.println("================================");
            System.out.println(ex.toString());
            System.out.println("================================");
            ex.printStackTrace();
        }
    }
 
    public static int binToDecimal(String bin) throws NumberFormatException {
        int decimalValue = 0;
        for (int i = 0; i < bin.length(); i++) {
            char binChar = bin.charAt(i);
            decimalValue = decimalValue * 2 + binCharToDecimal(binChar);
        }
        return decimalValue;
    }
    
    public static int binCharToDecimal(char ch) throws NumberFormatException {
        if (ch >= '0' && ch <= '1')
            return ch - '0';
        else {
            throw new NumberFormatException("Illegal char: " + ch);
        }
    }    
}
