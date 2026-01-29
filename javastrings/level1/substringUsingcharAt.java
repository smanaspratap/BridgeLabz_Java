/*Write a program to create a substring from a String using the charAt() method. Also, use the String built-in method substring() to find the substring of the text. Finally Compare the the two strings and display the results
Hint => 
Take user input using the  Scanner next() method to take the String variable and also the start and the end index to get the substring from the given text
Write a method to create a substring from a string using the charAt() method with the string, start, and end index as the parameters
Write a method to compare two strings using the charAt() method and return a boolean result
Use the String built-in method substring() to get the substring and compare the two strings. And finally display the result
 */

import java.util.*;

public class substringUsingcharAt {

    static String substringUsingcharat(String s, int start, int end){
        String result = "";
        for(int i = start; i<end; i++){
            result = result + s.charAt(i);
        }
        return result;
    } 

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
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String str = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        // Substring using our own method
        String sub1 = substringUsingcharat(str, start, end);

        // Substring using built-in method
        String sub2 = str.substring(start, end);

        // Compare both substrings
        boolean result = compareUsingcharAt(sub1, sub2);

        // Display results
        System.out.println("Substring using charAt(): " + sub1);
        System.out.println("Substring using substring(): " + sub2);
        System.out.println("Are both substrings equal? " + result);   
        sc.close();     
    
  }  
}
