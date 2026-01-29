/*Write a program to demonstrate IllegalArgumentException
Hint => 
Define a variable of type String and take user input to assign a value
Write a Method to generate the Exception. Here use the subString() and set the start index to be greater than the end index. 
This will generate a runtime exception and abruptly stop the program. Write the Method to demonstrate IllegalArgumentException. 
Here use the subString() and set the start index to be greater than the end index. This will generate a runtime exception. 
Use the try-catch block to handle the IllegalArgumentException and the generic runtime exception
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
 */


import java.util.*;

public class IllegalArgumentExcep{

    // Method to generate IllegalArgumentException
    static void generateException(String text) {

        // start index greater than end index
        System.out.println("Substring: " + text.substring(5, 2));
    }

    // Method to handle IllegalArgumentException
    static void handleException(String text) {

        try {
            // Again start index greater than end index
            System.out.println("Substring: " + text.substring(5, 2));
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught and handled.");
            System.out.println("Reason: Start index is greater than end index.");
        }
        catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String str = sc.next();

        // First: generate exception
        System.out.println("\nGenerating IllegalArgumentException:");
        try {
            generateException(str);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Exception occurred in generateException()");
        }

        // Then: handle exception properly
        System.out.println("\nHandling IllegalArgumentException:");
        handleException(str);
        sc.close();
    }
}
