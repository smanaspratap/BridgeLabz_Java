
package exceptions;
/*
 * Try-With-Resources Demo - Automatic Resource Closing
 * This program reads first line of a file using try-with-resources
 * Automatically closes BufferedReader even if exception occurs
 */

import java.io.*;

public class TryWithResourcesDemo {
    
    public static void main(String[] args) {
        System.out.println("===== try-with-resources =====\n");
        
        // Try-with-resources automatically closes BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            
            // Reading first line from file
            String firstLine = reader.readLine();
            
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty");
            }
            
            // No need to explicitly close reader - automatically handled
            
        } catch (IOException e) {
            // Handling file not found or read errors
            System.out.println("Error reading file");
        }
        
        System.out.println("\nNote: BufferedReader was automatically closed!");
    }
}
