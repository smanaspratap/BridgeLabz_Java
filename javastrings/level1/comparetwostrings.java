/*Write a program to compare two strings using the charAt() method and check the result with the built-in String equals() method
Hint => 
Take user input using the  Scanner next() method for 2 String variables
Write a method to compare two strings using the charAt() method and return a boolean result
Use the String Built-In method to check if the results are the same and display the result 
 */

import java.util.*;
public class comparetwostrings{

    static boolean compareUsingcharAt(String s1, String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        for(int i = 0 ; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = in.next();

        System.out.print("Enter second string: ");
        String str2 = in.next();

        // Using our own method
        boolean result1 = compareUsingcharAt(str1, str2);

        // Using built-in equals()
        boolean result2 = str1.equals(str2);

        // Display results
        System.out.println("Result using charAt() method: " + result1);
        System.out.println("Result using equals() method: " + result2);

        // Check if both results are same
        if (result1 == result2) {
            System.out.println("Both methods give the SAME result.");
        } else {
            System.out.println("Both methods give DIFFERENT results.");
        }  
        in.close();      
    }
}