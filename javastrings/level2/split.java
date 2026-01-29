
/*Write a program to split the text into words, compare the result with the split() method and display the result 
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to find the length of the String without using the built-in length() method. 
Create a Method to split the text into words using the charAt() method without using the String built-in split() method and return the words. Use the following logic
Firstly Count the number of words in the text and create an array to store the indexes of the spaces for each word in a 1D array
Then Create an array to store the words and use the indexes to extract the words
Create a method to compare the two String arrays and return a boolean
The main function calls the user-defined method and the built-in split() method. Call the user defined method to compare the two string arrays and display the result */
import java.util.*;
public class split {
    static int lenofstr(String s){
        int count = 0;
        char arr[] = s.toCharArray();
        for(int i: arr){
            count ++;
        }
        return count;
    }
    static String[] splitusingCharAt(String s){
        int len = lenofstr(s);

        //to count words
        int words = 1;
        for(int i = 0; i<len; i++){
            if(s.charAt(i) == ' '){
                words++;
            }
        }
        //store indexes of spaces
        int[] spaceindex = new int[words -1];
        int k =0;
        for(int i = 0; i<len; i++){
            if(s.charAt(i) == ' '){
                spaceindex[k++] = i;
            }
        }
        String[] result = new String[words];

        int start = 0;
        int idx = 0;

        for (int i = 0; i < spaceindex.length; i++) {
            int end = spaceindex[i];
            result[idx++] = s.substring(start, end);
            start = end + 1;
        }

        // Last word
        result[idx] = s.substring(start, len);

        return result;
    }
    static boolean compareArrays(String[] a, String[] b) {

        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Take full text input
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        // Using user-defined method
        String[] arr1 = splitusingCharAt(text);

        // Using built-in split()
        String[] arr2 = text.split(" ");

        // Compare both results
        boolean result = compareArrays(arr1, arr2);

        // Display results
        System.out.println("\nWords using charAt(): " + Arrays.toString(arr1));
        System.out.println("Words using split(): " + Arrays.toString(arr2));
        System.out.println("Are both results equal? " + result);
        sc.close();
    }
    
}
