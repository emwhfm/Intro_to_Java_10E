/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threadsynchronize;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 *
 * @author emwhfm
 */
public class ThreadSynchronize {

    private static final Sum sum = new Sum();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Create and launch 1000 threads
        for (int i = 0; i < 1000; i++) {
            executor.execute(new AddTask());
        }

        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        } 

        System.out.println("What is sum? " + sum.getSum());
    }
    
    // A thread for adding a penny to the account
    private static class AddTask implements Runnable {
        @Override
        public void run() {
            sum.add(1);
        }
    }
    
    // An inner class for account
    private static class Sum {
        
        private Integer sum = 0;
        private static final Lock lock = new ReentrantLock();

        public int getSum() {
            return sum;
        }
        
        //public synchronized void add(int i) {
        public void add(int i) {
            lock.lock();
            
            try {
                int temp_sum = sum + i;
                Thread.sleep(1);
                sum = temp_sum;
            }
            catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
            finally {
                lock.unlock();
            }
        }
    }
}
