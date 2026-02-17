package exceptions;
/*
 * Nested Try-Catch Demo - Multiple Exception Levels
 * This program demonstrates nested exception handling
 * Outer try-catch handles array exceptions, inner handles arithmetic exceptions
 */

import java.util.Scanner;

public class NestedTryCatch {
    
    public static void main(String[] args) {
        System.out.println("===== Nested try-catch =====\n");
        
        Scanner scanner = new Scanner(System.in);
        
        // Sample array for demonstration
        int[] array = {10, 20, 30, 40, 50};
        
        System.out.println("Array: [10, 20, 30, 40, 50]");
        
        // Outer try-catch for array operations
        try {
            System.out.print("Enter index (0-4): ");
            int index = scanner.nextInt();
            
            // Accessing array element - may throw ArrayIndexOutOfBoundsException
            int element = array[index];
            System.out.println("Element at index " + index + ": " + element);
            
            // Inner try-catch for division operation
            try {
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();
                
                // Performing division - may throw ArithmeticException
                int result = element / divisor;
                System.out.println("\nResult: " + element + " / " + divisor + " = " + result);
                
            } catch (ArithmeticException e) {
                // Inner catch handles division by zero
                System.out.println("\nCannot divide by zero!");
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // Outer catch handles invalid array index
            System.out.println("\nInvalid array index!");
            
        } finally {
            scanner.close();
        }
    }
}
