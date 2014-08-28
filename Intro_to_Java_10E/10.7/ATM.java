/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm;

import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class ATM {
    
    private static final int NUM_OF_ACCOUNT = 10;    
    
    private static int getId() {
        Scanner input = new Scanner(System.in);
        boolean validId = false;
        int tryId = 0;
        
        System.out.println("");
        
        while(!validId) {
            System.out.print("Enter an id: ");
             tryId = input.nextInt();
             if (tryId >=0 && tryId < NUM_OF_ACCOUNT - 1) {
                 validId = true;
             }
        }
        return tryId;
    }
    
    private static int getChoice() {
        Scanner input = new Scanner(System.in);
        boolean validChoice = false;
        int tryChoice = 0;
        
        while(!validChoice) {
            System.out.print("Enter an choice: ");
             tryChoice = input.nextInt();
             if (tryChoice >=1 && tryChoice <= 4) {
                 validChoice = true;
             }
        }
        return tryChoice;    
    }
    
    private static void execChoice(int choice, Account account) {
        Scanner input = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("The balance is " + account.getBalance());
                break;
            case 2:
                System.out.print("Enter an amount to withdraw: ");
                account.withdraw(input.nextDouble());
                break;
            case 3:
                System.out.print("Enter an amount to deposit: ");
                account.deposit(input.nextDouble());
                break;
            default:
                System.out.println("Unexpected choice!");
        }
    }
    
    private static void printMenu() {
        System.out.println("");
        System.out.println("Main menu");
        System.out.println("1: check balance");
        System.out.println("2: withdraw");
        System.out.println("3: deposit");
        System.out.println("4: exit");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int currentId;
        int currentChoice = 0;
        
        Account[] accounts = new Account[NUM_OF_ACCOUNT];
        for(int i=0; i<accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }
        
        while(true) {
            currentId = getId();
            printMenu();            
            currentChoice = getChoice();
            while (currentChoice != 4) {
                execChoice(currentChoice, accounts[currentId]);
                printMenu();            
                currentChoice = getChoice();
            }
        }
    }
    
}
