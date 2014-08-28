/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zeller;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class Zeller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        // h = (q + 26(m + 1)/10 + k + k/4 + j/4 + 5j)  % 7
        // h = day of week 0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday,
        //                 4: Wednesday, 5: Thursday, 6: Friday
        // q = day of the month
        // m = month 3: March, 4: April, ..., 12: December).
        //           January and February are counted as months 13 and 14
        // j = century => year/100
        // k = year of the century => yeay mod 100
        
        System.out.print("Enter year: (e.g., 2012): ");
        int year = input.nextInt();
        
        System.out.print("Enter month: 1-12: ");
        int m = input.nextInt();
        
        // Special handling of Jan and Feb
        if (m < 3) {
            m += 12;
            year--;
        }
        
        System.out.print("Enter the day of the month: 1-31: ");
        int q = input.nextInt();
        
        int weekday = (q + 26 * (m + 1)/10 + (year % 100) + (year % 100) / 4 + year / 100 / 4 + 5 * year / 100) % 7;
        
        System.out.print("Day of the week is ");
        
        switch (weekday) {
            case 0:
                System.out.println("Saturday");
                break;
            case 1:
                System.out.println("Sunday");
                break; 
            case 2:
                System.out.println("Monday");
                break;
           case 3:
                System.out.println("Tuesday");
                break;     
           case 4:
                System.out.println("Wednesday");
                break;
           case 5:
                System.out.println("Thursday");
                break;   
           case 6:
                System.out.println("Friday");
                break;
           default:
                System.out.println("Unknwown");
        }
        
        
    }
    
}
