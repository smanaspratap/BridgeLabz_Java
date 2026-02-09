package stackqueuehashmap;
/*
    Find all subarrays with Zero Sum using HashMap.
    We compute cumulative sum while traversing the array.
    If the same sum appears again, elements in between sum to zero.
    HashMap stores sum and list of indices where it occurred.
    Whenever a repeat is found, print all valid subarrays.
    Time complexity is O(n) on average.
*/

import java.util.*;

class ZeroSumSubarrays {

    // Find and print all zero sum subarrays
    public static void findSubarrays(int[] arr) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int sum = 0;

        map.put(0, new ArrayList<>(Arrays.asList(-1))); // Handle subarrays starting from index 0

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // If sum already exists, zero-sum subarray found
            if (map.containsKey(sum)) {

                ArrayList<Integer> list = map.get(sum);

                for (int startIndex : list) {
                    System.out.println("Subarray found from index " + (startIndex + 1) + " to " + i);
                }

                list.add(i); // Add current index
            }
            else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(sum, newList); // Store first occurrence
            }
        }
    }

    // Main method to test
    public static void main(String[] args) {

        int[] arr = {3, 4, -7, 1, 2, -6, 4, -1};

        findSubarrays(arr);
    }
}
