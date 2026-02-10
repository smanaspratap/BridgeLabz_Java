package sorting;

/*
    Quick Sort to arrange product prices in ascending order.
    Select a pivot and partition the array around it.
    Elements smaller than pivot go left, larger go right.
    Recursively sort both partitions.
    Works in-place with no extra memory.
    Average time complexity is O(n log n).
*/

import java.util.*;

class QuickSortPrices {

    // Apply quick sort recursively
    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);  // Sort left part
            quickSort(arr, pivotIndex + 1, high); // Sort right part
        }
    }

    // Partition array around pivot
    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high]; // Choosing last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {

            // Place elements smaller than pivot
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Move pivot to correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Main method to test
    public static void main(String[] args) {

        int[] prices = {799, 299, 499, 199, 999, 149};

        System.out.println("Original Prices: " + Arrays.toString(prices));

        quickSort(prices, 0, prices.length - 1);

        System.out.println("Sorted Prices: " + Arrays.toString(prices));
    }
}

