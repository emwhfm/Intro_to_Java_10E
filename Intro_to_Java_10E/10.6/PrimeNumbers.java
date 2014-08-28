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
public class PrimeNumbers {
    
    private static final int DEFAULT_LIMIT = 100;
    private int limit;
    private StackOfIntegers stack;
            
    public PrimeNumbers() {
        this(DEFAULT_LIMIT);
    }
    
    public PrimeNumbers(int limit) {
        this.limit = limit;
        stack = new StackOfIntegers();
    } 
    
    public void Calculate() {
        for(int i=2; i<limit; i++) {
            if (isPrime(i)) {
                stack.push(i);
            }
        }
    }
    
    public void Print() {
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
    private static boolean isPrime(int n) {
        for(int i=2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
