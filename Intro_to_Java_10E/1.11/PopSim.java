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

public class PopSim {
    public static void main(String[] args) {
        final int START_POPULATION = 312_032_486;
        final int DAYS_PER_YEAR = 365;
        
        Scanner input = new Scanner(System.in);        
        
        System.out.print("Enter the number of years : ");
        int numberOfYears = input.nextInt();
        
        // One birth every 7 seconds
        // One death every 13 seconds
        // One new immigrant every 45 seconds               
        
        int totalNumberOfDays = numberOfYears * DAYS_PER_YEAR;
        int totalNumberOfSeconds = totalNumberOfDays * 24 * 3600;
        
        int births = totalNumberOfSeconds / 7;
        int deaths = totalNumberOfSeconds / 13;
        int immigrants = totalNumberOfSeconds / 45;
        
        int population = START_POPULATION + births - deaths + immigrants;
        
        System.out.println("The population in " + numberOfYears + " is " + population);
        
        
        
    }
}
