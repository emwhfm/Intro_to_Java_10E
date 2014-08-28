/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stopwatch;

/**
 *
 * @author emwhfm
 */
public class StopWatch {

    private long startTime;
    private long endTime;
    
    public StopWatch() {
        startTime = System.currentTimeMillis();
    }
    
    public long getStartTime() {
        return startTime;
    }
    
    public long getEndTime() {
        return endTime;
    }
    
    public void start() {
        startTime = System.currentTimeMillis();
    }
    
    public void stop() {
        endTime = System.currentTimeMillis();
    }
    
    public long getElapsedTime() {
        return endTime - startTime;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StopWatch myClock = new StopWatch();
        try {
            Thread.sleep(999);
        }
        catch (InterruptedException e) {
            System.out.println("Exception occurred!!!");
        }
        myClock.stop();
        System.out.println("Time in millisec = " + myClock.getElapsedTime());
    }
    
}
