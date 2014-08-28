/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package converttemperature;

/**
 *
 * @author emwhfm
 */
public class ConvertTemperature {

    /** Convert from Celsius to Fahrenheit */
    public static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }
    
    /** Convert from Fahrenheit to Celsius */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Celsius       Fahrenheit");
        for (int c=40; c>30; c--) {
            System.out.printf("%4.1f          %5.1f\n", (double)c, celsiusToFahrenheit((double)c));
        }
        
        System.out.println();
        System.out.println();
        
        System.out.println("Fahrenheit       Celsius");
        for (int f=120; f>29; f--) {
            System.out.printf("%5.1f            %5.2f\n", (double)f, fahrenheitToCelsius((double)f));
        }
    }
    
}
