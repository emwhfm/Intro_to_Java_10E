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
public class Transaction {

    private java.util.Date date;
    private char type; // 'D' deposit  'W' withdrawal
    private double amount;
    private double balance;
    private String description;
    
    public Transaction(char type,
                       double amount,
                       double balance,
                       String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        date = new java.util.Date();
    }
    
    public void setType(char type) {
        this.type = type;
    }
    
    public char getType() {
        return type;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public java.util.Date getDate() {
        return date;
    }
    
}
