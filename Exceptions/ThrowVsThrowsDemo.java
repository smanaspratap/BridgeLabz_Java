package exceptions;
/*
 * Throw vs Throws Demo - Exception Propagation
 * This program demonstrates the difference between throw and throws
 * Calculates interest and propagates exceptions using throws keyword
 */

import java.util.Scanner;

public class ThrowVsThrowsDemo {
    
    // Method that throws exception - declared using 'throws' keyword
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        
        // Validation check - throws exception using 'throw' keyword
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        
        // Calculating simple interest
        return (amount * rate * years) / 100;
    }
    
    public static void main(String[] args) {
        System.out.println("===== throw vs. throws =====\n");
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Taking input from user
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            
            System.out.print("Enter rate (%): ");
            double rate = scanner.nextDouble();
            
            System.out.print("Enter years: ");
            int years = scanner.nextInt();
            
            // Calling method that may throw exception
            double interest = calculateInterest(amount, rate, years);
            System.out.println("\nCalculated interest: $" + interest);
            
        } catch (IllegalArgumentException e) {
            // Catching exception propagated from calculateInterest method
            System.out.println("\n" + e.getMessage());
            
        } finally {
            scanner.close();
        }
    }
}
