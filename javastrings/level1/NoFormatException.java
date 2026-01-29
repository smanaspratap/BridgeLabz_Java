/*Write a program to demonstrate NumberFormatException
Hint => 
Define a variable to take user input as a String 
Use Integer.parseInt() to generate this exception. Integer.parseInt() is a built-in function in java.lang.Integer class to extract the number from text. In case the text does not contain numbers the method will throw NumberFormatException which is a runtime exception
Write a Method to generate the Exception. Use Integer.parseInt(text) to extract number from the text. This will generate a runtime exception and abruptly stop the program. 
Write the Method to demonstrate NumberFormatException. Use Integer.parseInt(text) to extract number from the text. This will generate a runtime exception. Use the try-catch block to handle the NumberFormatException as well as the generic runtime exception
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
 */


import java.util.*;

public class NoFormatException {

    static void generateException(String text) {

        int num = Integer.parseInt(text);

        System.out.println("Converted number: " + num);
    }

   
    static void handleException(String text) {

        try {
            int num = Integer.parseInt(text);
            System.out.println("Converted number: " + num);
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught and handled.");
            System.out.println("Reason: Input string does not contain a valid number.");
        }
        catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter a value (string): ");
        String str = sc.next();

        
        System.out.println("\nGenerating NumberFormatException:");
        try {
            generateException(str);
        }
        catch (NumberFormatException e) {
            System.out.println("Exception occurred in generateException()");
        }

        
        System.out.println("\nHandling NumberFormatException:");
        handleException(str);
        sc.close();
    }
}

