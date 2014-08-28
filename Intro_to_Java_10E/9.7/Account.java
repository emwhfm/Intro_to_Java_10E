/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package account2;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author emwhfm
 */
public class Account {
    
    private int id;
    private double balance;
    private static double annualInterestRate = 0;
    
    private java.util.Date dateCreated;
    
    private String name;
    
    private ArrayList<Transaction> transactions;
            
    public Account() {
        this(0, 0);      
    }
    
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new java.util.Date();  
        transactions = new ArrayList<>();
    }
    
    public Account(String name, int id, double balance) {
        this(id, balance);
        this.name = name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }
    
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }
    
    public java.util.Date getDateCreated() {
        return dateCreated;
    }
    
    public String getName() {
        return name;
    }
    
    public double getMonthlyInterestRate() {
        return annualInterestRate / 1200;
    }
    
    public double getMonthlyInterest() {
        return balance * annualInterestRate / 1200;
    }
    
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            Transaction transaction = new Transaction('W', amount, balance, "withdraw");
            transactions.add(transaction);
        }
    }
    
    public void deposit(double amount) {
        balance += amount;
        Transaction transaction = new Transaction('D', amount, balance, "desposit");
        transactions.add(transaction);
    }
    
    public int getTransactionSize() {
        return transactions.size();
    }
    
    public Transaction gettransaction(int index) {
        return transactions.get(index);
    }
}
