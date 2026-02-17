package exceptions;
/*
 * Try-With-Resources - Multiple File Processing
 * This program reads contents from multiple files using try-with-resources
 * Ensures all file resources are properly closed even if exceptions occur
 */

import java.io.*;
import java.util.*;

// Class to process multiple files
class FileProcessor {
    
    // Method to process list of files - each file handled with try-with-resources
    public void processFiles(List<String> filePaths) {
        System.out.println("Processing " + filePaths.size() + " files...\n");
        
        // Iterating through each file path
        for (String filePath : filePaths) {
            // Try-with-resources ensures BufferedReader is automatically closed
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                
                System.out.println("Reading file: " + filePath);
                String line;
                int lineNumber = 1;
                
                // Reading file line by line
                while ((line = reader.readLine()) != null) {
                    System.out.println("  Line " + lineNumber + ": " + line);
                    lineNumber++;
                }
                
                System.out.println("Successfully processed: " + filePath + "\n");
                
            } catch (IOException e) {
                // Handling file not found or read errors
                System.err.println("Error processing file: " + filePath);
                System.err.println("Error details: " + e.getMessage() + "\n");
            }
            // BufferedReader automatically closed here
        }
        
        System.out.println("All files processed!");
    }
}

public class FileProcessorDemo {
    
    public static void main(String[] args) {
        System.out.println("===== Try-With-Resources Demo =====\n");
        
        // Creating list of file paths to process
        List<String> filePaths = new ArrayList<>();
        filePaths.add("file1.txt");
        filePaths.add("file2.txt");
        filePaths.add("file3.txt");
        
        // Creating FileProcessor instance
        FileProcessor processor = new FileProcessor();
        
        // Processing all files
        processor.processFiles(filePaths);
        
        System.out.println("\nNote: All resources were automatically closed using try-with-resources!");
    }
}
