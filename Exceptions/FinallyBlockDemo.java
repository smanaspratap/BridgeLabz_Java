package exceptions;
/*
 * Finally Block Demo - Guaranteed Execution
 * This program demonstrates that finally block always executes
 * Shows finally execution in both normal and exceptional scenarios
 */

import java.util.Scanner;

public class FinallyBlockDemo {
    
    public static void main(String[] args) {
        System.out.println("===== finally Block =====\n");
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Taking input for division
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            
            // Performing division - may throw ArithmeticException
            int result = num1 / num2;
            System.out.println("\nResult: " + result);
            
        } catch (ArithmeticException e) {
            // Handling division by zero
            System.out.println("\nError: Cannot divide by zero!");
            
        } finally {
            // This block ALWAYS executes - whether exception occurs or not
            System.out.println("Operation completed");
            System.out.println("(finally block executed)");
            scanner.close();
        }
        
        System.out.println("\nProgram ended successfully");
    }
}
