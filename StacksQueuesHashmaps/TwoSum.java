package stackqueuehashmap;
/*
    Two Sum Problem using HashMap.
    Traverse the array while storing elements and their indices.
    For each element, compute the complement (target - current).
    If complement exists in the map, return the indices.
    This avoids nested loops and improves efficiency.
    Time complexity is O(n).
*/

import java.util.*;

class TwoSum {

    // Find indices of two numbers adding to target
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // Check if complement already seen
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i); // Store current element with index
        }

        return new int[]{-1, -1}; // No valid pair found
    }

    // Main method to test
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        if (result[0] != -1) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found.");
        }
    }
}
