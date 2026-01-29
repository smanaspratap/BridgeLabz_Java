/*Write a program to find the sum of n natural numbers using recursive method and compare the result with the formulae n*(n+1)/2 and show the result from both computations is correct. 
Hint => 
Take the user input number and check whether it's a Natural number, if not exit
Write a Method to find the sum of n natural numbers using recursion
Write a Method to find the sum of n natural numbers using the formulae n*(n+1)/2 
Compare the two results and print the result
 */
import java.util.*;
public class recursivesumofno {
    static int recursiveSum(int n) {
        if (n == 0) return 0;
        return n + recursiveSum(n - 1);
    }
    static int formulaSum(int n) { return n * (n + 1) / 2; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            
        }
        int r1 = recursiveSum(n);
        int r2 = formulaSum(n);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1 == r2);
        sc.close();
    }
}
