package sorting;

/*
    Insertion Sort to arrange employee IDs in ascending order.
    Divide the array into sorted and unsorted sections.
    Pick each element and insert it into the correct position.
    Shift larger elements one position ahead.
    Efficient for small or nearly sorted arrays.
    Time complexity is O(n^2), but best case is O(n).
*/

import java.util.*;

class InsertionSortIDs {

    // Perform insertion sort on employee IDs
    public static void insertionSort(int[] ids) {

        for (int i = 1; i < ids.length; i++) {

            int key = ids[i]; // Element to insert
            int j = i - 1;

            // Shift elements greater than key
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }

            ids[j + 1] = key; // Place key at correct position
        }
    }

    // Main method to test
    public static void main(String[] args) {

        int[] ids = {1045, 1021, 1090, 1012, 1067};

        System.out.println("Original Employee IDs: " + Arrays.toString(ids));

        insertionSort(ids);

        System.out.println("Sorted Employee IDs: " + Arrays.toString(ids));
    }
}
