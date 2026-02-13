package runtimeanalysis;
/*
 * FibonacciComputationComparator evaluates the performance
 * difference between recursive and iterative Fibonacci methods.
 * It demonstrates how exponential recursion becomes impractical
 * compared to linear iteration for larger inputs.
 */

public class FibonacciComputationComparator {

    // Exponential time complexity due to repeated subproblem calculations
    public static long testRecursive(int n) {
        long start = System.nanoTime();
        fibonacciRecursive(n);
        return System.nanoTime() - start;
    }

    // Linear time with constant space
    public static long testIterative(int n) {
        long start = System.nanoTime();
        fibonacciIterative(n);
        return System.nanoTime() - start;
    }

    // Classic recursion with overlapping subproblems (very slow for large n)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Efficient bottom-up computation
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n; // Handles edge cases

        int a = 0, b = 1, sum;

        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }

    public static void main(String[] args) {

        int[] testValues = {10, 30, 40}; // Avoid extremely large recursion times

        System.out.printf("%-15s %-20s %-20s%n",
                "Fibonacci(N)", "Recursive(ns)", "Iterative(ns)");

        for (int n : testValues) {

            long recursiveTime = testRecursive(n);
            long iterativeTime = testIterative(n);

            System.out.printf("%-15d %-20d %-20d%n",
                    n, recursiveTime, iterativeTime);
        }
    }
}
