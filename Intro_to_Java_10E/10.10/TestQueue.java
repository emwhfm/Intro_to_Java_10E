/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package queue;

/**
 *
 * @author emwhfm
 */
public class TestQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue myQueue = new Queue();
        for(int i=1; i<=20; i++) {
            myQueue.enqueue(i);
        }
        for(int i=1; i<=20; i++) {
            int value = myQueue.dequeue();
            System.out.print(i + " ");
        }
    }
}
