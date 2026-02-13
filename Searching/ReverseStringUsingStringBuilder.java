/*StringBuilder Problem 1: Reverse a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to reverse a given string. For example, if the input is "hello", the output should be "olleh".
Approach:
Create a new StringBuilder object.
Append the string to the StringBuilder.
Use the reverse() method of StringBuilder to reverse the string.
Convert the StringBuilder back to a string and return it.
*/

public class ReverseStringUsingStringBuilder {
    //Method to reverse the string.
    public static String reverseString(String input){
        StringBuilder str = new StringBuilder(String.valueOf(input));
        str.reverse();
        return str.toString();

    }
    //Calling in the method to return reverse of the string.
    public static void main(String[] args) {
        String result = reverseString("Hello");
        System.out.println(result);
    }
}
