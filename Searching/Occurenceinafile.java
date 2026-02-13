import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*FileReader Problem 2: Count the Occurrence of a Word in a File Using FileReader
Problem:
Write a program that uses FileReader and BufferedReader to read a file and count how many times a specific word appears in the file.
Approach:
Create a FileReader to read from the file and wrap it in a BufferedReader.
Initialize a counter variable to keep track of word occurrences.
For each line in the file, split it into words and check if the target word exists.
Increment the counter each time the word is found.
Print the final count.
*/
class Occurenceinafile{
    static void main(String[] args) {
        String FilePath = "I:\\BridgeLabz_Java\\Searching\\textfile.txt";
        String target = "the";
        int count = 0;

        try(BufferedReader read = new BufferedReader(new FileReader(FilePath))) {
            String line;
            while((line = read.readLine()) != null){
                //Convert all the lines to lowercase
                line = line.toLowerCase();

                // Remove all the punctuations.
                line = line.replaceAll("^[a-z ]","");

                //Split into words
                String[] words = line.split("\\s+");

                // Check each word
                for (String word : words) {
                    if (word.equals(target.toLowerCase())) {
                        count++;
                    }
                }

            }
            System.out.println("The word '" + target + "' appears " + count + " times.");
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}