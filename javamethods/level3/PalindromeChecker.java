/*Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
Hint => 
Method to find the count of digits in the number and a Method to Store the digits of the number in a digits array
Method to reverse the digits array 
Method to compare two arrays and check if they are equal
Method to check if a number is a palindrome using the Digits. A palindrome number is a number that remains the same when its digits are reversed. 
Method to Check if a number is a duck number using the digits array. A duck number is a number that has a non-zero digit present in it
 */
public class P4_PalindromeChecker {
    static boolean isPalindrome(int n){
        String s=""+n;
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    public static void main(String[] args){
        int n=121;
        System.out.println("Palindrome: "+isPalindrome(n));
    }
}
