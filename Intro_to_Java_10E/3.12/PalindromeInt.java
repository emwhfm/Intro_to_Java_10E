/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package palindromeint;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class PalindromeInt {

    // Return the reversal of an integer, i.e., reverse(456) returns 654
    public static int reverse(int number) {
        int tmp = number;
        int len = 0;
        int reverse = 0;
        
        // Calculate number of digits
        while (true) {
            if (tmp < 10) {
                len++;
                break;
            }      
            tmp /= 10;
            len++;
        }
        System.out.println("len=" + len);
        
        tmp = number;
        for (int i=0; i<len; i++) {
            int digit = tmp % 10;
            tmp /= 10;
            reverse += digit * Math.pow(10, len-i-1);
        }
        System.out.println("reverse=" + reverse);    
        return reverse;
    }
            
    // Return true if number is a palindrome
    public static boolean isPalindrome(int number) {        
        return (number == reverse(number));
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter integer number : ");
        int number = input.nextInt();
        System.out.println(isPalindrome(number) ? "Is palindrome" : "Is not palindrome");
    }
    
}
