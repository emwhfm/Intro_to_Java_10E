/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emwhfm
 */
import java.util.Scanner;

public class SumIntDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter integer digit [0-1000]: ");
        int Number = input.nextInt();
        
        //System.out.println(Number);
        /* int Digit1 = Number % 10;
        int Rest = (Number - Digit1) / 10;
        
        int Digit2 = Rest % 10;
        Rest = (Rest - Digit2) / 10;
        
        int Digit3 = Rest % 10;
        Rest = (Rest - Digit3) / 10;
        
        int Digit4 = Rest % 10;
        Rest = (Rest - Digit4) / 10;*/
        int Rest = Number;
        
        int Digit1 = Rest % 10;
        Rest /= 10;
        
        int Digit2 = Rest % 10;
        Rest /= 10;
        
        int Digit3 = Rest % 10;
        Rest /= 10;
        
        int Digit4 = Rest % 10;
        Rest /= 10;
        
        int Sum = Digit1 + Digit2 + Digit3 + Digit4;
        System.out.println("Digit sum = " + Sum);
    }
}
