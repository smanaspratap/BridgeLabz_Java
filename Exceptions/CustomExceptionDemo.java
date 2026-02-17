package exceptions;
/*
 * Custom Exception - Age Validation
 * This program validates user's age using a custom exception
 * Throws InvalidAgeException if age is below 18
 */

import java.util.Scanner;

// Custom exception class for invalid age
class InvalidAgeException extends Exception {
    // Constructor to set custom error message
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {
    
    // Method to validate age - throws custom exception if age < 18
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throwing custom exception for invalid age
            throw new InvalidAgeException("Age must be 18 or above");
        }
        System.out.println("Access granted!");
    }
    
    public static void main(String[] args) {
        System.out.println("===== Custom Exception =====\n");
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Taking age input from user
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            
            // Validating the age
            validateAge(age);
            
        } catch (InvalidAgeException e) {
            // Catching and displaying custom exception message
            System.out.println(e.getMessage());
            
        } finally {
            scanner.close();
        }
    }
}
