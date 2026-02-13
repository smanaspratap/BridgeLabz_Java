/*InputStreamReader Problem 2: Read User Input and Write to File Using InputStreamReader
Problem:
Write a program that uses InputStreamReader to read user input from the console and write the input to a file. Each input should be written as a new line in the file.
Approach:
Create an InputStreamReader to read from System.in (the console).
Wrap the InputStreamReader in a BufferedReader for efficient reading.
Create a FileWriter to write to the file.
Read user input using readLine() and write the input to the file.
Repeat the process until the user enters "exit" to stop inputting.
Close the file after the input is finished.
*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadConsoleAndWriteToFile {

    public static void main(String[] args) {

        // File where user input will be stored
        String filePath = "I:\\BridgeLabz_Java\\Searching\\textfile.txt";

        try (
                // Step 1: Create InputStreamReader to read from console (System.in)
                InputStreamReader isr = new InputStreamReader(System.in);

                // Step 2: Wrap it with BufferedReader for efficient reading
                BufferedReader br = new BufferedReader(isr);

                // Step 3: Create FileWriter to write into file
                FileWriter writer = new FileWriter(filePath);
        ) {

            String input;

            System.out.println("Enter text (type 'exit' to stop):");

            // Step 4: Keep reading user input until "exit" is entered
            while ((input = br.readLine()) != null) {

                // If user types "exit", stop the loop
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                // Write user input to file
                writer.write(input);

                // Write a new line after each input
                writer.write(System.lineSeparator());
            }

            System.out.println("Data successfully written to file.");

        } catch (IOException e) {

            // Handle possible input/output errors
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
