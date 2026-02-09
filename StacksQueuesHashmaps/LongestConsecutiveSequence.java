package stackqueuehashmap;
/*
    Longest Consecutive Sequence using HashSet.
    Store all elements for O(1) lookup.
    Start counting only when the current number is the beginning of a sequence.
    A number is a start if (num - 1) is not present.
    Expand forward to count consecutive elements.
    Overall time complexity is O(n).
*/

import java.util.*;

class LongestConsecutiveSequence {

    // Find length of longest consecutive sequence
    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num); // Insert all elements
        }

        int longest = 0;

        for (int num : set) {

            // Check if it's the start of a sequence
            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                // Count consecutive numbers
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count); // Update max length
            }
        }

        return longest;
    }

    // Main method to test
    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);

        System.out.println("Length of Longest Consecutive Sequence: " + result);
    }
}
