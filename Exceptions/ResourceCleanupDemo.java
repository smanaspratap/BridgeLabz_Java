package exceptions;
/*
 * Exception Handling with Resource Cleanup
 * This program demonstrates managing connections with proper cleanup
 * Shows exception handling while ensuring resources are always released
 */

import java.util.*;

// Custom exception for connection failures
class ConnectionException extends Exception {
    // Constructor with message
    public ConnectionException(String message) {
        super(message);
    }
    
    // Constructor with message and cause
    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Class representing a database connection that requires cleanup
class DatabaseConnection {
    private String connectionId;
    private boolean isConnected;
    private boolean hasError;
    
    // Constructor to initialize connection
    public DatabaseConnection(String connectionId) {
        this.connectionId = connectionId;
        this.isConnected = false;
        this.hasError = false;
    }
    
    // Method to establish connection
    public void connect() throws ConnectionException {
        System.out.println("Attempting to connect: " + connectionId);
        
        // Simulating connection logic
        try {
            Thread.sleep(100); // Simulate network delay
            this.isConnected = true;
            System.out.println("Successfully connected: " + connectionId);
        } catch (InterruptedException e) {
            throw new ConnectionException("Connection interrupted: " + connectionId, e);
        }
    }
    
    // Method to execute query - may throw exception
    public void executeQuery(String query) throws ConnectionException {
        if (!isConnected) {
            throw new ConnectionException("Cannot execute query: Not connected!");
        }
        
        System.out.println("Executing query: " + query);
        
        // Simulating query execution with potential failure
        if (query.contains("ERROR")) {
            hasError = true;
            throw new ConnectionException("Query execution failed: Invalid query syntax");
        }
        
        System.out.println("Query executed successfully");
    }
    
    // Method to close connection - must always be called
    public void close() {
        if (isConnected) {
            System.out.println("Closing connection: " + connectionId);
            this.isConnected = false;
            System.out.println("Connection closed successfully");
        } else {
            System.out.println("Connection already closed: " + connectionId);
        }
    }
    
    // Getter for connection status
    public boolean isConnected() {
        return isConnected;
    }
}

// Manager class to handle database operations with proper cleanup
class DatabaseManager {
    
    // Method demonstrating resource cleanup with try-catch-finally
    public void performDatabaseOperation(String query) {
        DatabaseConnection connection = null;
        
        try {
            // Creating and establishing connection
            connection = new DatabaseConnection("DB-" + System.currentTimeMillis());
            connection.connect();
            
            // Executing query - may throw exception
            connection.executeQuery(query);
            
            System.out.println("Operation completed successfully\n");
            
        } catch (ConnectionException e) {
            // Handling connection or query errors
            System.err.println("Database operation failed!");
            System.err.println("Error: " + e.getMessage());
            
            // Logging original cause if available
            if (e.getCause() != null) {
                System.err.println("Caused by: " + e.getCause().getMessage());
            }
            System.err.println();
            
        } finally {
            // Ensuring cleanup happens regardless of success or failure
            System.out.println("Performing cleanup in finally block...");
            
            if (connection != null) {
                // Always close connection to free resources
                connection.close();
            }
            
            System.out.println("Cleanup completed\n");
        }
    }
}

public class ResourceCleanupDemo {
    
    public static void main(String[] args) {
        System.out.println("===== Exception Handling with Resource Cleanup Demo =====\n");
        
        // Creating database manager
        DatabaseManager manager = new DatabaseManager();
        
        // Test Case 1: Successful operation with proper cleanup
        System.out.println("Test 1: Successful database operation");
        System.out.println("----------------------------------------");
        manager.performDatabaseOperation("SELECT * FROM users");
        
        // Test Case 2: Failed operation with proper cleanup
        System.out.println("Test 2: Failed database operation");
        System.out.println("----------------------------------------");
        manager.performDatabaseOperation("SELECT ERROR FROM invalid_table");
        
        // Test Case 3: Another successful operation
        System.out.println("Test 3: Another successful operation");
        System.out.println("----------------------------------------");
        manager.performDatabaseOperation("INSERT INTO users VALUES (1, 'John')");
        
        System.out.println("All operations completed!");
        System.out.println("\nNote: Resources were properly cleaned up in all scenarios,");
        System.out.println("whether operations succeeded or failed.");
    }
}
