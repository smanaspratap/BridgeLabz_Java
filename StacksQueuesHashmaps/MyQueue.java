package stackqueuehashmap;
import java.util.Stack;

/*
    Queue Implementation using Two Stacks.
    This approach maintains FIFO order by using two LIFO stacks.
    stack1 is used for enqueue operations, while stack2 handles dequeue.
    Elements are transferred from stack1 to stack2 only when needed.
    This makes each element move at most once, keeping operations efficient.
    Amortized time complexity for enqueue and dequeue is O(1).
*/


class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    // Initialize both stacks
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Add element to the queue
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Remove element from the queue
    public int dequeue() {

        // Transfer elements only if stack2 is empty
        if (stack2.isEmpty()) {

            // Moving elements to maintain FIFO order
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack2.pop();
    }

    // Get the front element without removing it
    public int peek() {

        // Ensure stack2 has the current front
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack2.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

//Main function
class question1 {
    public static void main(String[] args) {
        MyQueue q1 = new MyQueue();

        q1.enqueue(5);
        q1.enqueue(6);

        System.out.println("Dequeued: " + q1.dequeue());
        System.out.println("Peek: " + q1.peek());
        System.out.println("Is Empty: " + q1.isEmpty());
    }
}
