package task6;

import java.util.ArrayList;

public class Accounts {
    private String accountName;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Accounts(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: " + balance);
    }

    @Override
    public String toString() {
        return "Account Name: " + accountName + ", Balance: " + balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            System.out.println("Successfully withdrew " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History for " + accountName + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
