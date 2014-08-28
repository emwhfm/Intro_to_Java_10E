/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vowel;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class Vowel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final String VOWEL = "AOUEIY";
        
        System.out.print("Enter a letter: ");
        String my_str = input.next();
        char my_char = my_str.charAt(0);
        
        if (!Character.isLetter(my_char)) {
            System.out.println(my_char + " is an invalid input");
            System.exit(1);
        }
        
        if (VOWEL.indexOf(Character.toUpperCase(my_char)) == -1) {
            System.out.println(my_char + " is a consonant");
        }
        else {
            System.out.println(my_char + " is a vowel");
        }
    }
    
}
