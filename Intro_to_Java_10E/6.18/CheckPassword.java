/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package checkpassword;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class CheckPassword {
    
    
    public static boolean valid_rule_1(String passwd) {
        final int PASSWD_LENGTH = 8;
        return passwd.length() >= PASSWD_LENGTH;
    }
    
    public static boolean valid_rule_2(String passwd) {
        for (int i=0; i<passwd.length(); i++) {
            char ch = passwd.charAt(i);
            if (!(Character.isDigit(ch) ^ Character.isLetter(ch))) {
                return false;
            }
        }
        return true;
    }
     
    public static boolean valid_rule_3(String passwd) {
        final int MIN_NR_DIGITS = 2;
        int count = 0;
        for (int i=0; i<passwd.length(); i++) {
            char ch = passwd.charAt(i);
            if (Character.isDigit(ch)) { 
                count++;
            }
        }
        return count >= MIN_NR_DIGITS; 
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter password : ");
        String passwd = input.next();
        
        if (!valid_rule_1(passwd)) {
            System.out.println("Invalid password");
            System.exit(1);
        }
        
        if (!valid_rule_2(passwd)) {
            System.out.println("Invalid password");
            System.exit(1);
        }
     
        if (!valid_rule_3(passwd)) {
            System.out.println("Invalid password");
            System.exit(1);
        }
        
        System.out.println("Valid password");
    }
    
}
