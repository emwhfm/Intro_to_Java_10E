/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perfectnumber;

/**
 *
 * @author emwhfm
 */
public class PerfectNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int MAX_LIMIT = 10_000;
        int sum;
        
        for (int i=1; i<MAX_LIMIT; i++ ) {
        
            sum = 0;
            for (int j=1; j<i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            
            if (i == sum) {
                System.out.println(i + " is a perfect number");
            }
        }
    }
    
}
