package stackqueuehashmap;

/*
    Sliding Window Maximum using Deque.
    We maintain indices of elements in decreasing order inside the deque.
    The front always contains the index of the maximum element.
    Remove indices that are out of the current window.
    Also remove smaller elements since they are useless.
    Time complexity is O(n) because each element is processed once.
*/

import java.util.*;

class SlidingWindowMaximum {

    // Find maximum for each window
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0 || k <= 0)
            return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices outside the window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i); // Add current index

            // Start recording results when first window is complete
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    // Main method to test
    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Sliding Window Maximum: " + Arrays.toString(result));
    }
}

