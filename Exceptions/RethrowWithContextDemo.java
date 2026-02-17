package exceptions;
/*
 * Rethrowing Exceptions with Custom Context - Transaction Processing
 * This program demonstrates catching and rethrowing custom exceptions with added context
 * Shows how to provide detailed error information through exception rethrowing
 */

import java.util.*;

// Custom exception for transaction failures
class TransactionException extends Exception {
    private String transactionId;
    private double amount;
    
    // Constructor with detailed context
    public TransactionException(String message, String transactionId, double amount) {
        super(message);
        this.transactionId = transactionId;
        this.amount = amount;
    }
    
    // Constructor with message and cause
    public TransactionException(String message, Throwable cause, String transactionId, double amount) {
        super(message, cause);
        this.transactionId = transactionId;
        this.amount = amount;
    }
    
    // Getter methods
    public String getTransactionId() {
        return transactionId;
    }
    
    public double getAmount() {
        return amount;
    }
}

// Class to process user transactions
class TransactionProcessor {
    private Map<String, Double> accountBalances;
    
    // Constructor to initialize accounts
    public TransactionProcessor() {
        this.accountBalances = new HashMap<>();
        // Setting up sample accounts
        accountBalances.put("ACC001", 1000.0);
        accountBalances.put("ACC002", 500.0);
    }
    
    // Method that processes basic transaction validation
    private void validateTransaction(String accountId, double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            // Throwing exception for invalid amount
            throw new IllegalArgumentException("Transaction amount must be positive");
        }
        
        if (!accountBalances.containsKey(accountId)) {
            // Throwing exception for invalid account
            throw new IllegalArgumentException("Account not found: " + accountId);
        }
        
        if (accountBalances.get(accountId) < amount) {
            // Throwing exception for insufficient funds
            throw new IllegalArgumentException("Insufficient funds in account: " + accountId);
        }
    }
    
    // Method that processes transaction and rethrows with custom context
    public void processTransaction(String transactionId, String accountId, double amount) 
            throws TransactionException {
        
        System.out.println("Processing transaction: " + transactionId);
        System.out.println("Account: " + accountId + ", Amount: $" + amount);
        
        try {
            // Attempting to validate transaction
            validateTransaction(accountId, amount);
            
            // Processing the transaction
            double currentBalance = accountBalances.get(accountId);
            accountBalances.put(accountId, currentBalance - amount);
            
            System.out.println("Transaction successful!");
            System.out.println("New balance: $" + accountBalances.get(accountId) + "\n");
            
        } catch (IllegalArgumentException e) {
            // Catching original exception and rethrowing with additional context
            String contextMessage = "Transaction failed for ID: " + transactionId + 
                                  " | Original error: " + e.getMessage();
            
            // Rethrowing as custom exception with full context
            throw new TransactionException(contextMessage, e, transactionId, amount);
        }
    }
    
    // Method to display account balances
    public void displayBalances() {
        System.out.println("Current Account Balances:");
        for (Map.Entry<String, Double> entry : accountBalances.entrySet()) {
            System.out.println("  " + entry.getKey() + ": $" + entry.getValue());
        }
        System.out.println();
    }
}

public class RethrowWithContextDemo {
    
    public static void main(String[] args) {
        System.out.println("===== Rethrowing with Custom Context Demo =====\n");
        
        // Creating transaction processor
        TransactionProcessor processor = new TransactionProcessor();
        
        // Display initial balances
        processor.displayBalances();
        
        // Test Case 1: Valid transaction (should succeed)
        try {
            System.out.println("Test 1: Valid transaction");
            processor.processTransaction("TXN001", "ACC001", 200.0);
        } catch (TransactionException e) {
            handleTransactionError(e);
        }
        
        // Test Case 2: Invalid amount (should fail and rethrow)
        try {
            System.out.println("Test 2: Invalid amount (negative)");
            processor.processTransaction("TXN002", "ACC001", -50.0);
        } catch (TransactionException e) {
            // Handling rethrown exception with custom context
            handleTransactionError(e);
        }
        
        // Test Case 3: Insufficient funds (should fail and rethrow)
        try {
            System.out.println("Test 3: Insufficient funds");
            processor.processTransaction("TXN003", "ACC002", 1000.0);
        } catch (TransactionException e) {
            // Handling rethrown exception with custom context
            handleTransactionError(e);
        }
        
        // Display final balances
        processor.displayBalances();
    }
    
    // Helper method to handle and display transaction errors with context
    private static void handleTransactionError(TransactionException e) {
        System.err.println("TRANSACTION ERROR OCCURRED!");
        System.err.println("Error Message: " + e.getMessage());
        System.err.println("Transaction ID: " + e.getTransactionId());
        System.err.println("Transaction Amount: $" + e.getAmount());
        
        // Displaying original cause if available
        if (e.getCause() != null) {
            System.err.println("Root Cause: " + e.getCause().getMessage());
        }
        System.err.println();
    }
}
