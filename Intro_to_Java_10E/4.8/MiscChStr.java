/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miscchstr;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class MiscChStr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 4.8
        System.out.print("Enter an ASCII code : ");
        byte my_byte = input.nextByte();
        char my_char = (char)my_byte;
        System.out.println("The character for ASCII code " + my_byte + " is " + my_char);
        
        // 4.9
        System.out.print("Enter a character : ");
        String my_str = input.next();
        char my_char2 = my_str.charAt(0);
        short my_val = (short)my_char2;
        System.out.println("The Unicode for the character " + my_char2 + " is " + my_val);
    }
    
}
