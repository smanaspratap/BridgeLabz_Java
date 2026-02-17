package Exceptions;
/*
 * Checked Exception Handling - File Reading
 * This program reads content from a file named "data.txt"
 * Demonstrates handling of checked exceptions using try-catch block
 */

import java.io.*;

public class CheckedExceptionDemo {
    
    public static void main(String[] args) {
        System.out.println("===== Checked Exception (IOException) =====\n");
        
        // Try to read file and handle IOException if file doesn't exist
        try {
            // Creating FileReader to read the file
            FileReader fileReader = new FileReader("data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            System.out.println("File contents:");
            // Reading file line by line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            
            // Closing the reader to free resources
            bufferedReader.close();
            
        } catch (IOException e) {
            // Handling the exception when file is not found
            System.out.println("File not found");
        }
    }
}
