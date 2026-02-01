/*Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
Hint => 
Method to Check if a number is prime number. A prime number is a number greater than 1 that has no positive divisors other than 1 and itself. 
Method to Check if a number is a neon number. A neon number is a number where the sum of digits of the square of the number is equal to the number itself 
Method to Check if a number is a spy number. A number is called a spy number if the sum of its digits is equal to the product of its digits
Method to Check if a number is an automorphic number. An automorphic number is a number whose square ends with the number itself. E.g. 5 is an automorphic number
Method to Check if a number is a buzz number. A buzz number is a number that is either divisible by 7 or ends with 7
 */
public class P5_SpecialNumbers {
    static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++) if(n%i==0) return false;
        return true;
    }
    static boolean isBuzz(int n){ return n%7==0 || n%10==7; }
    public static void main(String[] args){
        int n=7;
        System.out.println("Prime: "+isPrime(n));
        System.out.println("Buzz: "+isBuzz(n));
    }
}
