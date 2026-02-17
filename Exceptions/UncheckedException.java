
package exceptions;/*
 * Unchecked Exception Handling - Division Operation
 * This program performs division of two numbers entered by user
 * Handles ArithmeticException and InputMismatchException
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class UncheckedException {
    
    public static void main(String[] args) {
        System.out.println("===== Unchecked Exception =====\n");
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Taking input from user
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            
            // Performing division - may throw ArithmeticException
            int result = num1 / num2;
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            // Handling division by zero
            System.out.println("Error: Cannot divide by zero!");
            
        } catch (InputMismatchException e) {
            // Handling non-numeric input
            System.out.println("Error: Please enter valid numeric values!");
            
        } finally {
            // Closing scanner to prevent resource leak
            scanner.close();
        }
    }
}
