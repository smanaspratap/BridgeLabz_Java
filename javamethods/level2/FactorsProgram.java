/*Create a program to find the factors of a number taken as user input, store the factors in an array and display the factors. Also find the sum, sum of square of factors and product of the factors and display the results
Hint => 
Take the input for a number
Write a static Method to find the factors of the number and save them in an array and return the array. 
To find factors and save to array will have two loops. The first loop to find the count and initialize the array with the count. And the second loop save the factors into the array
Write a method to find the sum of the factors using factors array
Write a method to find the product of the factors using factors array
Write a method to find the sum of square of the factors using Math.pow() method
 */

import java.util.*;

public class FactorsProgram {
    static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;

        int[] arr = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) arr[idx++] = i;

        return arr;
    }

    static int sum(int[] a) {
        int s = 0;
        for (int x : a) s += x;
        return s;
    }

    static long product(int[] a) {
        long p = 1;
        for (int x : a) p *= x;
        return p;
    }

    static double sumOfSquares(int[] a) {
        double s = 0;
        for (int x : a) s += Math.pow(x, 2);
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] f = getFactors(n);

        System.out.println(Arrays.toString(f));
        System.out.println("Sum = " + sum(f));
        System.out.println("Product = " + product(f));
        System.out.println("Sum of Squares = " + sumOfSquares(f));
        sc.close();
    }
}
