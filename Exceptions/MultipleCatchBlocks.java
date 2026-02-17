package exceptions;
/*
 * Multiple Catch Blocks - Array Operations
 * This program demonstrates handling multiple exceptions for array operations
 * Catches ArrayIndexOutOfBoundsException and NullPointerException
 */

import java.util.Scanner;

public class MultipleCatchBlocks {
    
    public static void main(String[] args) {
        System.out.println("===== Multiple Catch Blocks =====\n");
        
        Scanner scanner = new Scanner(System.in);
        
        // Sample array for demonstration
        int[] array = {10, 20, 30, 40, 50};
        
        try {
            // Displaying array contents
            System.out.println("Array: [10, 20, 30, 40, 50]");
            System.out.print("Enter index to access (0-4): ");
            int index = scanner.nextInt();
            
            // Accessing array element - may throw ArrayIndexOutOfBoundsException
            int value = array[index];
            System.out.println("Value at index " + index + ": " + value);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handling invalid array index
            System.out.println("Invalid index!");
            
        } catch (NullPointerException e) {
            // Handling null array reference
            System.out.println("Array is not initialized!");
            
        } finally {
            scanner.close();
        }
    }
}
