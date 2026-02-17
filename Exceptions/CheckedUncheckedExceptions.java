package exceptions;
/*
 * Checked and Unchecked Exceptions Handling
 * This program demonstrates throwing and handling both checked and unchecked exceptions
 * Shows the difference between exception types and proper handling techniques
 */

import java.io.*;

// Custom checked exception for data validation
class InvalidDataException extends Exception {
    // Constructor with message
    public InvalidDataException(String message) {
        super(message);
    }
}

// Class to process various types of data
class DataProcessor {
    
    // Method that throws both checked and unchecked exceptions
    public void processData(String data, int divisor) throws InvalidDataException, IOException {
        
        System.out.println("Processing data: " + data);
        
        // Validation 1: Check for null or empty data (throws unchecked exception)
        if (data == null) {
            // Throwing unchecked exception (NullPointerException)
            throw new NullPointerException("Data cannot be null!");
        }
        
        // Validation 2: Check for empty data (throws checked exception)
        if (data.trim().isEmpty()) {
            // Throwing checked exception
            throw new InvalidDataException("Data cannot be empty!");
        }
        
        // Validation 3: Check for invalid format (throws checked exception)
        if (!data.matches("^[a-zA-Z0-9]+$")) {
            // Throwing checked exception for invalid format
            throw new InvalidDataException("Data contains invalid characters! Only alphanumeric allowed.");
        }
        
        // Operation that may throw unchecked exception
        try {
            // This may throw ArithmeticException (unchecked)
            int result = data.length() / divisor;
            System.out.println("Calculation result: " + result);
        } catch (ArithmeticException e) {
            // Wrapping unchecked exception in checked exception
            throw new InvalidDataException("Arithmetic error during processing: " + e.getMessage());
        }
        
        // Simulating file operation that throws checked IOException
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("processed_data.txt", true))) {
            // Writing processed data - may throw IOException (checked)
            writer.write(data + "\n");
            System.out.println("Data written to file successfully");
        }
        // IOException propagates automatically due to throws declaration
        
        System.out.println("Data processing completed successfully!\n");
    }
}

public class CheckedUncheckedExceptions {
    
    public static void main(String[] args) {
        System.out.println("===== Checked and Unchecked Exceptions Demo =====\n");
        
        // Creating data processor instance
        DataProcessor processor = new DataProcessor();
        
        // Test Case 1: Valid data (should succeed)
        try {
            System.out.println("Test 1: Valid data processing");
            processor.processData("TestData123", 2);
            
        } catch (InvalidDataException e) {
            // Handling checked exception
            System.err.println("Checked Exception: " + e.getMessage() + "\n");
        } catch (IOException e) {
            // Handling checked exception
            System.err.println("IO Exception: " + e.getMessage() + "\n");
        } catch (NullPointerException e) {
            // Handling unchecked exception
            System.err.println("Unchecked Exception: " + e.getMessage() + "\n");
        }
        
        // Test Case 2: Null data (throws unchecked exception)
        try {
            System.out.println("Test 2: Null data");
            processor.processData(null, 2);
            
        } catch (InvalidDataException e) {
            System.err.println("Checked Exception: " + e.getMessage() + "\n");
        } catch (IOException e) {
            System.err.println("IO Exception: " + e.getMessage() + "\n");
        } catch (NullPointerException e) {
            // Handling unchecked NullPointerException
            System.err.println("Unchecked Exception (NPE): " + e.getMessage() + "\n");
        }
        
        // Test Case 3: Empty data (throws checked exception)
        try {
            System.out.println("Test 3: Empty data");
            processor.processData("   ", 2);
            
        } catch (InvalidDataException e) {
            // Handling custom checked exception
            System.err.println("Checked Exception: " + e.getMessage() + "\n");
        } catch (IOException e) {
            System.err.println("IO Exception: " + e.getMessage() + "\n");
        } catch (NullPointerException e) {
            System.err.println("Unchecked Exception: " + e.getMessage() + "\n");
        }
        
        // Test Case 4: Invalid format (throws checked exception)
        try {
            System.out.println("Test 4: Invalid data format");
            processor.processData("Test@Data!", 2);
            
        } catch (InvalidDataException e) {
            // Handling custom checked exception
            System.err.println("Checked Exception: " + e.getMessage() + "\n");
        } catch (IOException e) {
            System.err.println("IO Exception: " + e.getMessage() + "\n");
        } catch (NullPointerException e) {
            System.err.println("Unchecked Exception: " + e.getMessage() + "\n");
        }
        
        // Test Case 5: Division by zero (throws unchecked, converted to checked)
        try {
            System.out.println("Test 5: Division by zero scenario");
            processor.processData("ValidData", 0);
            
        } catch (InvalidDataException e) {
            // Handling checked exception (converted from ArithmeticException)
            System.err.println("Checked Exception: " + e.getMessage() + "\n");
        } catch (IOException e) {
            System.err.println("IO Exception: " + e.getMessage() + "\n");
        } catch (NullPointerException e) {
            System.err.println("Unchecked Exception: " + e.getMessage() + "\n");
        }
        
        System.out.println("Program execution completed!");
    }
}
