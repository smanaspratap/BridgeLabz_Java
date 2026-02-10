package sorting;

/*
    Counting Sort to arrange student ages in ascending order.
    Count frequency of each age within the known range.
    Convert counts into cumulative positions.
    Place elements into the output array based on positions.
    Works best when the range of values is small.
    Time complexity is O(n + k).
*/

import java.util.*;

class CountingSortAges {

    // Perform counting sort
    public static void countingSort(int[] ages) {

        int min = 10, max = 18;
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Store frequency of each age
        for (int age : ages) {
            count[age - min]++;
        }

        // Convert to cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (iterate backwards for stability)
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        // Copy sorted data back
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    // Main method to test
    public static void main(String[] args) {

        int[] ages = {15, 12, 18, 10, 14, 12, 17, 13};

        System.out.println("Original Ages: " + Arrays.toString(ages));

        countingSort(ages);

        System.out.println("Sorted Ages: " + Arrays.toString(ages));
    }
}

