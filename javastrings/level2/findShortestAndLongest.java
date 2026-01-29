/*Write a program to split the text into words and find the shortest and longest strings in a given text
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to split the text into words using the charAt() method without using the String built-in split() method and return the words.
Create a method to find and return a string's length without using the length() method. 
Create a method to take the word array and return a 2D String array of the word and its corresponding length. Use String built-in function String.valueOf() to generate the String value for the number
Create a Method that takes the 2D array of word and corresponding length as parameters, find the shortest and longest string and return them in an 1D int array. 
The main function calls the user-defined methods and displays the result.
 */

import java.util.*;

public class findShortestAndLongest {

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

    // Method to find shortest and longest word indexes
    static int[] findShortestAndLongest(String[][] table) {

        int minIndex = 0;
        int maxIndex = 0;

        int minLen = Integer.parseInt(table[0][1]);
        int maxLen = Integer.parseInt(table[0][1]);

        for (int i = 1; i < table.length; i++) {

            int currLen = Integer.parseInt(table[i][1]);

            if (currLen < minLen) {
                minLen = currLen;
                minIndex = i;
            }

            if (currLen > maxLen) {
                maxLen = currLen;
                maxIndex = i;
            }
        }

        // Return indexes of shortest and longest words
        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take full text input
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        // Split into words
        String[] words = splitUsingCharAt(text);

        // Create 2D array of word and length
        String[][] table = wordsWithLength(words);

        // Find shortest and longest
        int[] result = findShortestAndLongest(table);

        int shortestIndex = result[0];
        int longestIndex = result[1];

        // Display results
        System.out.println("\nWords and their lengths:");
        System.out.println("Word\tLength");
        System.out.println("----------------");

        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + Integer.parseInt(table[i][1]));
        }

        System.out.println("\nShortest word: " + table[shortestIndex][0] +
                           " (Length = " + table[shortestIndex][1] + ")");

        System.out.println("Longest word: " + table[longestIndex][0] +
                           " (Length = " + table[longestIndex][1] + ")");
                           sc.close();
    }
}
