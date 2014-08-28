/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package primenumbers;

/**
 *
 * @author emwhfm
 */
public class TestPrimeNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrimeNumbers prime = new PrimeNumbers(120);
        prime.Calculate();
        prime.Print();
    }
}
