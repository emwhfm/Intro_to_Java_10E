/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gregorian;

import java.util.GregorianCalendar;

/**
 *
 * @author emwhfm
 */
public class Gregorian {

    private static void printCalendar(GregorianCalendar calendar) {
        System.out.println("Year : " + calendar.get(GregorianCalendar.YEAR));
        System.out.println("Month : " + calendar.get(GregorianCalendar.MONTH));
        System.out.println("Day : " + calendar.get(GregorianCalendar.DAY_OF_MONTH)); 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        printCalendar(calendar);
        
        calendar.setTimeInMillis(1234567898765L);
        printCalendar(calendar);
    }
    
}
