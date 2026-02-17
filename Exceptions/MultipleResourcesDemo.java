package exceptions;
/*
 * Try-With-Resources - Multiple Resources Management
 * This program reads from two files and writes combined output to a third file
 * Demonstrates managing multiple resources simultaneously with automatic cleanup
 */

import java.io.*;

public class MultipleResourcesDemo {
    
    // Method to combine contents of two files into a third file
    public static void combineFiles(String inputFile1, String inputFile2, String outputFile) {
        System.out.println("Combining files...");
        System.out.println("Input File 1: " + inputFile1);
        System.out.println("Input File 2: " + inputFile2);
        System.out.println("Output File: " + outputFile + "\n");
        
        // Try-with-resources with multiple resources separated by semicolons
        try (
            // First resource: reader for first input file
            BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
            // Second resource: reader for second input file
            BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2));
            // Third resource: writer for output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            
            // Reading and writing contents from first file
            System.out.println("Reading from " + inputFile1 + "...");
            writer.write("=== Contents from " + inputFile1 + " ===\n");
            String line;
            while ((line = reader1.readLine()) != null) {
                writer.write(line + "\n");
            }
            writer.write("\n");
            
            // Reading and writing contents from second file
            System.out.println("Reading from " + inputFile2 + "...");
            writer.write("=== Contents from " + inputFile2 + " ===\n");
            while ((line = reader2.readLine()) != null) {
                writer.write(line + "\n");
            }
            
            System.out.println("\nSuccessfully combined files into " + outputFile);
            
        } catch (FileNotFoundException e) {
            // Handling missing input files
            System.err.println("Error: One or more input files not found!");
            System.err.println("Details: " + e.getMessage());
            
        } catch (IOException e) {
            // Handling read/write errors
            System.err.println("Error: Problem reading or writing files!");
            System.err.println("Details: " + e.getMessage());
        }
        // All three resources (reader1, reader2, writer) automatically closed here
        
        System.out.println("\nAll resources automatically closed.");
    }
    
    public static void main(String[] args) {
        System.out.println("===== Multiple Resources Demo =====\n");
        
        // File paths
        String inputFile1 = "input1.txt";
        String inputFile2 = "input2.txt";
        String outputFile = "combined_output.txt";
        
        // Creating sample input files for demonstration
        createSampleFiles(inputFile1, inputFile2);
        
        // Combining files
        combineFiles(inputFile1, inputFile2, outputFile);
        
        // Reading and displaying the combined output
        displayFileContents(outputFile);
    }
    
    // Helper method to create sample input files
    private static void createSampleFiles(String file1, String file2) {
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(file1));
             BufferedWriter writer2 = new BufferedWriter(new FileWriter(file2))) {
            
            writer1.write("This is line 1 from file 1\n");
            writer1.write("This is line 2 from file 1\n");
            
            writer2.write("This is line 1 from file 2\n");
            writer2.write("This is line 2 from file 2\n");
            
        } catch (IOException e) {
            System.err.println("Error creating sample files: " + e.getMessage());
        }
    }
    
    // Helper method to display file contents
    private static void displayFileContents(String filename) {
        System.out.println("\n--- Combined Output File Contents ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading output file: " + e.getMessage());
        }
    }
}
