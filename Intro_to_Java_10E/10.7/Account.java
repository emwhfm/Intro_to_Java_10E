/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atm;

import java.util.Date;

/**
 *
 * @author emwhfm
 */
public class Account {
    
    private int id;
    private double balance;
    private static double annualInterestRate = 0;
    
    private java.util.Date dateCreated;
    
    public Account() {
        this(0, 0);      
    }
    
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new java.util.Date();      
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
    
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    
    public java.util.Date getDateCreated() {
        return dateCreated;
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
        }
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
}
