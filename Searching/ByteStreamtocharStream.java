/*InputStreamReader Problem 1: Convert Byte Stream to Character Stream Using InputStreamReader
Problem:
Write a program that uses InputStreamReader to read binary data from a file and print it as characters. The file contains data encoded in a specific charset (e.g., UTF-8).
Approach:
Create a FileInputStream object to read the binary data from the file.
Wrap the FileInputStream in an InputStreamReader to convert the byte stream into a character stream.
Use a BufferedReader to read characters efficiently from the InputStreamReader.
Read the file line by line and print the characters to the console.
Handle any encoding exceptions as needed.
*/

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ByteStreamtocharStream {

    public static void main(String[] args) {

        // Path of the file to be read
        String filePath = "I:\\BridgeLabz_Java\\Searching\\textfile.txt";

        // Try-with-resources automatically closes all streams
        try (
                // Step 1: Create FileInputStream to read raw bytes from the file
                FileInputStream fis = new FileInputStream(filePath);

                // Step 2: Wrap FileInputStream with InputStreamReader
                // This converts byte stream into character stream using UTF-8 encoding
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

                // Step 3: Wrap InputStreamReader with BufferedReader
                // BufferedReader improves efficiency and allows reading line by line
                BufferedReader br = new BufferedReader(isr);
        ) {

            String line;

            // Step 4: Read file line by line until end of file (null)
            while ((line = br.readLine()) != null) {

                // Print each line to console
                System.out.println(line);
            }

        } catch (IOException e) {

            // Handle file not found or reading errors
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}

