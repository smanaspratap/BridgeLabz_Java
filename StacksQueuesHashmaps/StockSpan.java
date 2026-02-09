package stackqueuehashmap;
/*
    Stock Span Problem using Stack.
    Span is the number of consecutive days before today
    where the stock price was less than or equal to today's price.
    We use a stack to store indices of useful days.
    Elements are popped until a greater price is found.
    This ensures each element is pushed and popped once.
    Overall time complexity is O(n).
*/

import java.util.Stack;
import java.util.Arrays;

class StockSpan {

    // Calculate span for each day
    public static int[] calculateSpan(int[] prices) {

        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(0); // First index always has span 1
        span[0] = 1;

        for (int i = 1; i < n; i++) {

            // Pop indices while current price is higher or equal
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack becomes empty, span is i+1
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            stack.push(i); // Push current index
        }

        return span;
    }

    // Main method to test
    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] result = calculateSpan(prices);

        System.out.println("Stock Prices: " + Arrays.toString(prices));
        System.out.println("Span Values : " + Arrays.toString(result));
    }
}
