/*Write a program to demonstrate StringIndexOutOfBoundsException
Hint => 
Define a variable of type String and take user input to assign a value
Write a Method to generate the Exception. Access the index using charAt() beyond the length of the String. This will generate a runtime exception and abruptly stop the program.
Write the Method to demonstrate StringIndexOutOfBoundsException. Access the index using charAt() beyond the length of the String. Then write try catch block for Exception while accessing the String method
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
 */

import java.util.*;

public class StringindexOutOfBoundsException{

    // Method to generate StringIndexOutOfBoundsException
    static void generateException(String text) {

        // Accessing index beyond length
        System.out.println("Character at invalid index: " + text.charAt(text.length()));
    }

    // Method to handle StringIndexOutOfBoundsException
    static void handleException(String text) {

        try {
            // Again accessing invalid index
            System.out.println("Character at invalid index: " + text.charAt(text.length()));
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught and handled.");
            System.out.println("Reason: Index is outside the valid range (0 to length-1).");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String str = sc.next();

        // First: generate exception
        System.out.println("\nGenerating StringIndexOutOfBoundsException:");
        try {
            generateException(str);
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception occurred in generateException()");
        }

        // Then: handle exception properly
        System.out.println("\nHandling StringIndexOutOfBoundsException:");
        handleException(str);
        sc.close();
    }
}

