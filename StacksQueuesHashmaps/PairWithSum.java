package stackqueuehashmap;
/*
    Check for a Pair with Given Sum using HashSet.
    Traverse the array and calculate the complement (target - current).
    If complement already exists, a valid pair is found.
    HashSet allows O(1) average lookup time.
    Each element is processed once, giving O(n) complexity.
    Space complexity is also O(n).
*/

import java.util.*;

class PairWithSum {

    // Check if pair exists
    public static boolean hasPair(int[] arr, int target) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {

            int complement = target - num;

            // If complement exists, pair found
            if (set.contains(complement)) {
                System.out.println("Pair found: " + complement + " + " + num + " = " + target);
                return true;
            }

            set.add(num); // Store current number
        }

        return false;
    }

    // Main method to test
    public static void main(String[] args) {

        int[] arr = {10, 15, 3, 7};
        int target = 17;

        boolean result = hasPair(arr, target);

        if (!result) {
            System.out.println("No pair found.");
        }
    }
}
