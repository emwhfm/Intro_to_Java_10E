/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        
package concurrentoutput;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

/**
 *
 * @author emwhfm
 */
public class PrintNum implements Runnable {

    private final int lastNum;
    private final TextArea ta;
    private int i;
    private final int sleep;
    
    /** Construct a task for printing 1, 2, ..., n */
    public PrintNum(TextArea ta, int sleep, int n) {
        this.ta = ta;
        this.sleep = sleep;
        lastNum = n;
    }
    
    @Override /** Tell the thread how to run */
    public void run() {
        try {
            for (i = 1; i <= lastNum; i++) {
                //System.out.print(" " + i);
                Platform.runLater(() -> {
                    ta.appendText(" " + Integer.toString(i) + " ");                
                });
                Thread.sleep(sleep);                
            }
        }
        catch (InterruptedException ex) {    
            System.out.println("Exception in " + ex.toString());   
        }
    }
}
