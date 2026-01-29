/*Write a program to find the sum of n natural numbers using loop
Hint => Get integer input from the user. Write a Method to find the sum of n natural numbers using loop 
 */
import java.util.*;
public class SumNaturalNumbers {

    static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = sumOfNaturalNumbers(n);
        System.out.println(result);
        sc.close();
    }
}