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
public class PrintChar implements Runnable {
    
    private final char charToPrint; // The character to print
    private final int times; // The number of times to repeat
    private final TextArea ta;
    private final int sleep;
    
    /** Construct a task with a specified character and number of
    * times to print the character
    */
    public PrintChar(TextArea ta, int sleep, char c, int t) {
        this.ta = ta;
        this.sleep = sleep;
        charToPrint = c;
        times = t;
    }
    
    @Override /** Override the run() method to tell the system
    * what task to perform
    */
    public void run() {
        try {
            for (int i = 0; i < times; i++) {
                //System.out.print(charToPrint);
                Platform.runLater(() -> {
                    ta.appendText(Character.toString(charToPrint));
                });
                Thread.sleep(sleep);               
            }
        }
        catch (InterruptedException ex) {            
            System.out.println("Exception in " + ex.toString());   
        }
    }        
}
