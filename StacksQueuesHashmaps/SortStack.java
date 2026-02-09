package stackqueuehashmap;
import java.util.Stack;
/*
    Sort a Stack using Recursion.
    The idea is to remove elements one by one until the stack is empty.
    Then insert each element back in a sorted manner.
    No extra data structure is used except the recursive call stack.
    insertSorted() places elements at their correct position.
    Time complexity is roughly O(n^2) due to repeated insertions.
*/



class SortStack {

    // Sort the entire stack
    public static void sort(Stack<Integer> stack) {

        if (stack.isEmpty())
            return;

        int top = stack.pop();

        sort(stack); // Recursively sort remaining stack

        insertSorted(stack, top); // Insert popped element correctly
    }

    // Insert element in sorted order
    private static void insertSorted(Stack<Integer> stack, int value) {

        // If stack is empty OR correct position found
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int top = stack.pop(); // Remove top to reach correct position

        insertSorted(stack, value);

        stack.push(top); // Put back the removed element
    }

    // Main method to test sorting
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        // Adding elements to stack
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Original Stack: " + stack);

        sort(stack);

        System.out.println("Sorted Stack (Ascending): " + stack);
    }
}
