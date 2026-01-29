/*Write a program to find and return the length of a string without using the length() method 
Hint => 
Take user input using the Scanner next() method 
Create a method to find and return a string's length without using the built-in length() method. The logic for this is to use the infinite loop to count each character till the charAt() method throws a runtime exception, handles the exception, and then return the count
The main function calls the user-defined method as well as the built-in length() method and displays the result
 */

import java.util.Scanner;

public class lengthofstring{

    static int lenofstr(String s){
        int count = 0;
        char[] arr = s.toCharArray();
        for(char i: arr){
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string");
        String a = in.next();
        int lengthofstring = lenofstr(a);
        System.out.println("The length of string is "+lengthofstring);
        System.out.println(a.length());
        in.close();


    }
}