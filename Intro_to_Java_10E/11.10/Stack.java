/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class Stack extends ArrayList<String> {

    public int getSize() {
        return this.size();
    }
    
    public String peek() {
        return this.get(this.getSize() - 1);
    }

    public String pop() {
        String tmp = this.get(this.getSize() - 1); 
        this.remove(this.getSize() - 1);
        return tmp;
    }
    
    public void push(String s) {
        this.add(s);
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack myStack = new Stack();
        
        for(int i=0; i<5; i++) {
            System.out.print("Enter string: ");
            String str = input.next();
            myStack.push(str);
        }
        System.out.println();
        for(int i=0; i<5; i++) {
            String str = myStack.pop();
            System.out.println(str);
        }
    }
    
}
