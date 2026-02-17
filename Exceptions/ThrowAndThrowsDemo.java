package exceptions;
/*
 * Throw and Throws - User Registration System
 * This program demonstrates throw and throws keywords with custom exceptions
 * Implements user registration with existence checking
 */

import java.util.*;

// Custom exception for user already exists scenario
class UserAlreadyExistsException extends Exception {
    // Constructor with custom message
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

// Custom exception for user not found scenario
class UserNotFoundException extends Exception {
    // Constructor with custom message
    public UserNotFoundException(String message) {
        super(message);
    }
}

// Service class to manage user operations
class UserService {
    // In-memory storage for registered users
    private Set<String> registeredUsers;
    
    // Constructor to initialize user storage
    public UserService() {
        this.registeredUsers = new HashSet<>();
        // Adding some existing users for demonstration
        registeredUsers.add("john_doe");
        registeredUsers.add("jane_smith");
    }
    
    // Method to register user - uses 'throws' to declare exception
    public void registerUser(String username) throws UserAlreadyExistsException {
        // Check if user already exists
        if (registeredUsers.contains(username)) {
            // Using 'throw' to explicitly throw exception
            throw new UserAlreadyExistsException("User '" + username + "' already exists in the system!");
        }
        
        // Register the new user
        registeredUsers.add(username);
        System.out.println("User '" + username + "' registered successfully!");
    }
    
    // Method to check user existence - uses 'throws' to declare exception
    public void checkUserExistence(String username) throws UserNotFoundException {
        // Check if user exists
        if (!registeredUsers.contains(username)) {
            // Using 'throw' to explicitly throw exception
            throw new UserNotFoundException("User '" + username + "' not found in the system!");
        }
        
        System.out.println("User '" + username + "' exists in the system.");
    }
    
    // Method to display all registered users
    public void displayUsers() {
        System.out.println("Registered users: " + registeredUsers);
    }
}

public class ThrowAndThrowsDemo {
    
    public static void main(String[] args) {
        System.out.println("===== Throw and Throws Demo =====\n");
        
        // Creating UserService instance
        UserService userService = new UserService();
        
        // Display existing users
        userService.displayUsers();
        System.out.println();
        
        // Test Case 1: Register new user (should succeed)
        try {
            System.out.println("Test 1: Registering new user 'alice_wong'");
            userService.registerUser("alice_wong");
            System.out.println();
        } catch (UserAlreadyExistsException e) {
            System.err.println("Registration failed: " + e.getMessage() + "\n");
        }
        
        // Test Case 2: Register existing user (should fail)
        try {
            System.out.println("Test 2: Registering existing user 'john_doe'");
            userService.registerUser("john_doe");
            System.out.println();
        } catch (UserAlreadyExistsException e) {
            // Handling exception when user already exists
            System.err.println("Registration failed: " + e.getMessage() + "\n");
        }
        
        // Test Case 3: Check existing user (should succeed)
        try {
            System.out.println("Test 3: Checking existence of 'jane_smith'");
            userService.checkUserExistence("jane_smith");
            System.out.println();
        } catch (UserNotFoundException e) {
            System.err.println("Check failed: " + e.getMessage() + "\n");
        }
        
        // Test Case 4: Check non-existing user (should fail)
        try {
            System.out.println("Test 4: Checking existence of 'bob_jones'");
            userService.checkUserExistence("bob_jones");
            System.out.println();
        } catch (UserNotFoundException e) {
            // Handling exception when user not found
            System.err.println("Check failed: " + e.getMessage() + "\n");
        }
        
        // Display final user list
        userService.displayUsers();
    }
}
