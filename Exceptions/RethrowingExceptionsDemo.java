
package exceptions;
/*
 * Rethrowing Exceptions - Division Operation
 * This program demonstrates rethrowing exceptions with additional context
 * Shows exception propagation through multiple method layers
 */

public class RethrowingExceptionsDemo {
    
    // Method that performs division and throws exception for zero denominator
    public static int performDivision(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            // Throwing exception when denominator is zero
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return numerator / denominator;
    }
    
    // Method that calls performDivision and rethrows exception with context
    public static int calculate(int numerator, int denominator) throws ArithmeticException {
        try {
            // Attempting division
            return performDivision(numerator, denominator);
            
        } catch (ArithmeticException e) {
            // Rethrowing exception with additional context
            throw new ArithmeticException("Error in calculate() method: " + e.getMessage() 
                + " [numerator=" + numerator + ", denominator=" + denominator + "]");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("===== Rethrowing Exceptions Demo =====\n");
        
        // Test Case 1: Valid division
        try {
            System.out.println("Test 1: Dividing 10 by 2");
            int result = calculate(10, 2);
            System.out.println("Result: " + result + "\n");
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage() + "\n");
        }
        
        // Test Case 2: Division by zero - will trigger rethrowing
        try {
            System.out.println("Test 2: Dividing 10 by 0");
            int result = calculate(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handling the rethrown exception with additional context
            System.err.println("Caught rethrown exception!");
            System.err.println("Error message: " + e.getMessage());
        }
        
        System.out.println("\nProgram completed successfully");
    }
}
