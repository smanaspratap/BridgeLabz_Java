/*Create a program to divide N number of chocolates among M children. Print the number of chocolates each child will get and also the remaining chocolates
Hint => 
Get an integer value from user for the numberOfchocolates and numberOfChildren.
Write the method to find the number of chocolates each child gets and number of remaining chocolates
public static int[] findRemainderAndQuotient(int number, int divisor) 
 */

import java.util.Scanner;

public class ChocolateDistribution {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int eachChild = number / divisor;
        int remaining = number % divisor;
        return new int[]{eachChild, remaining};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfChocolates = sc.nextInt();
        int numberOfChildren = sc.nextInt();

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        System.out.println(result[0]);
        System.out.println(result[1]);
        sc.close();
    }
}
