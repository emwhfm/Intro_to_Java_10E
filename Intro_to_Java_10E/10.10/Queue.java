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
public class Queue {

    private static final int DEFAULT_CAPACITY = 8;
    
    private int[] elements;
    private int size;
    
    public Queue() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }
 
    public void enqueue(int v) {
        if (size >= elements.length) {
            int temp[] = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = v;
    }
    
    public int dequeue() {
        int temp = elements[0];
        System.arraycopy(elements, 1, elements, 0, elements.length - 1);
        return temp;
    }
    
    public boolean empty() {
        return size == 0;
    }
    
    public int getSize() {
        return size;
    }
}
