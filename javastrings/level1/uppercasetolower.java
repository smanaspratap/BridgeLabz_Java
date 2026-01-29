/*Write a program to convert the complete text to uppercase and compare the results
Hint => 
Take user input using the  Scanner nextLine() method to take the complete text into a String variable
Write a method using the String built-in charAt() method to convert each character if it is lowercase to the Upper Case. Use the logic ASCII value of 'a' is 97 and 'A' is 65 so the difference is 32, similarly ASCII value of 'b' is 98 and 'B' is 66 so the difference is 32, and so on
Write a method to compare two strings using the charAt() method and return a boolean result
In the main() use the String built-in method toLowerCase() to get the Uppercase Text and compare the two strings using the user-defined method. And finally display the result
 */

import java.util.Scanner;
public class uppercasetolower {
   static String toUppercaseusingcharAt(String s){
        String result = "";
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(ch>= 'a' && ch<= 'z'){
                ch = (char)(ch-32);
            }
            result = result + ch;
        }
        return result;
   }
   static boolean compareusingcharAt(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        for(int i = 0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
   }
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the complete string ");
        String s = in.nextLine();

        String Upper1 = toUppercaseusingcharAt(s);

        String Upper2 = s.toUpperCase();

        boolean result = compareusingcharAt(Upper1, Upper2);

        System.out.println(Upper1);
        System.out.println(Upper2);
        System.out.println(result);

        in.close();

   } 
}
