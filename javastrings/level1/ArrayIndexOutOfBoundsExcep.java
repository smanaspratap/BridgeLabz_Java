/*Write a program to demonstrate ArrayIndexOutOfBoundsException
Hint => 
Define a variable of array of names and take input from the user
Write a Method to generate the Exception. Here access index larger then the length of the array. This will generate a runtime exception and abruptly stop the program. 
Write the Method to demonstrate ArrayIndexOutOfBoundsException. Here access index larger then the length of the array. This will generate a runtime exception. Use the try-catch block to handle the ArrayIndexOutOfBoundsException and the generic runtime exception
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
 */


import java.util.*;

public class ArrayIndexOutOfBoundsExcep{

    // Method to generate ArrayIndexOutOfBoundsException
    static void generateException(String[] names) {

        // Accessing index beyond array length
        System.out.println("Name at invalid index: " + names[names.length]);
    }

    // Method to handle ArrayIndexOutOfBoundsException
    static void handleException(String[] names) {

        try {
            // Again accessing invalid index
            System.out.println("Name at invalid index: " + names[names.length]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught and handled.");
            System.out.println("Reason: Index is outside the valid range (0 to length-1).");
        }
        catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input for array size
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];

        // Take names input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        // First: generate exception
        System.out.println("\nGenerating ArrayIndexOutOfBoundsException:");
        try {
            generateException(names);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception occurred in generateException()");
        }

        // Then: handle exception properly
        System.out.println("\nHandling ArrayIndexOutOfBoundsException:");
        handleException(names);
        sc.close();
    }
}

