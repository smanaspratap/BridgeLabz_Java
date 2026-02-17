package exceptions;
/*
 * Bank Transaction System - Custom and Checked Exceptions
 * This program implements a bank account with withdrawal functionality
 * Demonstrates custom exception and business logic validation
 */

import java.util.Scanner;

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    // Constructor with custom message
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account class with withdrawal logic
class BankAccount {
    private double balance;
    private String accountHolder;
    
    // Constructor to initialize account
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    // Method to withdraw money - throws custom and built-in exceptions
    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        
        // Validation: Check for negative amount
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        
        // Validation: Check for insufficient balance
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        
        // Perform withdrawal
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: $" + balance);
    }
    
    // Getter for balance
    public double getBalance() {
        return balance;
    }
    
    // Getter for account holder name
    public String getAccountHolder() {
        return accountHolder;
    }
}

public class BankTransactionSystem {
    
    public static void main(String[] args) {
        System.out.println("===== Bank Transaction System =====\n");
        
        Scanner scanner = new Scanner(System.in);
        
        // Creating a bank account with initial balance
        BankAccount account = new BankAccount("John Doe", 1000.0);
        
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Current Balance: $" + account.getBalance());
        System.out.println();
        
        try {
            // Taking withdrawal amount from user
            System.out.print("Enter withdrawal amount: $");
            double amount = scanner.nextDouble();
            
            // Attempting withdrawal - may throw exceptions
            account.withdraw(amount);
            
        } catch (InsufficientBalanceException e) {
            // Handling custom exception for insufficient balance
            System.out.println("\nError: " + e.getMessage());
            System.out.println("Available balance: $" + account.getBalance());
            
        } catch (IllegalArgumentException e) {
            // Handling invalid amount exception
            System.out.println("\nError: " + e.getMessage());
            
        } finally {
            scanner.close();
        }
        
        System.out.println("\nThank you for banking with us!");
    }
}
