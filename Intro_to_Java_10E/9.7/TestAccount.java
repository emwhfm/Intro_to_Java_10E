/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package account2;

/**
 *
 * @author emwhfm
 */
public class TestAccount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Account myAccount = new Account("George", 1122, 1000);
        Account.setAnnualInterestRate(1.5);
        
        myAccount.deposit(30);
        myAccount.deposit(40);
        myAccount.deposit(50);
        myAccount.withdraw(5);
        myAccount.withdraw(4);
        myAccount.withdraw(2);
        
        System.out.println("\nAccount summary");
        System.out.println("===============");
        
        System.out.println("Holder name: " + myAccount.getName());
        System.out.println("Annual interest rate: " + Account.getAnnualInterestRate());
        System.out.println("Balance: " + myAccount.getBalance());
        System.out.println("Transactions:");
        int size = myAccount.getTransactionSize();
        for(int i=0; i<size; i++) {
            Transaction t = myAccount.gettransaction(i);
            System.out.println("\tDate: " + t.getDate());
            System.out.println("\tType: " + t.getType());
            System.out.println("\tAmount: " + t.getAmount());
            System.out.println("\tBalance: " + t.getBalance());
            System.out.println("\tDescription: " + t.getDescription());            
        }
    }
}
