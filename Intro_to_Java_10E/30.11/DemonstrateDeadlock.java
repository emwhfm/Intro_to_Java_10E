/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demonstratedeadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author emwhfm
 */
public class DemonstrateDeadlock {

    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        
        executor.execute(new Task1());
        executor.execute(new Task2());
        
        executor.shutdown();        
    }
    
    private static class Task1 implements Runnable {
        @Override
        public void run() {
            try {                
                lock1.lock();
                System.out.println("T1 has taken lock1");
                Thread.sleep(200);
                lock2.lock();
                System.out.println("T1 has taken lock2");
            }
            catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    private static class Task2 implements Runnable {
        @Override
        public void run() {
            try {
                lock2.lock();
                System.out.println("T2 has taken lock2");
                Thread.sleep(200);
                lock1.lock();
                System.out.println("T2 has taken lock1");
            }
            catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
}
