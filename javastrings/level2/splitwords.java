/*Write a program to split the text into words and return the words along with their lengths in a 2D array
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to split the text into words using the charAt() method without using the String built-in split() method and return the words.
Create a method to find and return a string's length without using the length() method. 
Create a method to take the word array and return a 2D String array of the word and its corresponding length. Use String built-in function String.valueOf() to generate the String value for the number
The main function calls the user-defined method and displays the result in a tabular format. During display make sure to convert the length value from String to Integer and then display
 */


import java.util.*;

public class splitwords {

    // Method to find length without using length()
    static int findLength(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count++;
        }
        return count;
    }

    // Method to split text into words using charAt()
    static String[] splitUsingCharAt(String text) {

        int len = findLength(text);

        // Count words
        int words = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words++;
            }
        }

        // Store space indexes
        int[] spaceIndex = new int[words - 1];
        int k = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[k++] = i;
            }
        }

        // Extract words
        String[] result = new String[words];

        int start = 0;
        int idx = 0;

        for (int i = 0; i < spaceIndex.length; i++) {
            int end = spaceIndex[i];
            result[idx++] = text.substring(start, end);
            start = end + 1;
        }

        // Last word
        result[idx] = text.substring(start, len);

        return result;
    }

    // Method to create 2D array of word and its length
    static String[][] wordsWithLength(String[] words) {

        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {

            table[i][0] = words[i];   // word

            int len = findLength(words[i]);

            // Convert number to String
            table[i][1] = String.valueOf(len);
        }

        return table;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take full text input
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        // Split into words
        String[] words = splitUsingCharAt(text);

        // Create 2D array with word and length
        String[][] result = wordsWithLength(words);

        // Display in tabular format
        System.out.println("\nWord\tLength");
        System.out.println("----------------");

        for (int i = 0; i < result.length; i++) {

            String word = result[i][0];

            // Convert length String back to Integer
            int length = Integer.parseInt(result[i][1]);

            System.out.println(word + "\t" + length);

        }
        sc.close();
    }
}
