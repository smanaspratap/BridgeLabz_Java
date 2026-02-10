package sorting;

/*
    Merge Sort to arrange book prices in ascending order.
    It follows the divide and conquer approach.
    Recursively divide the array into halves.
    Sort each half and merge them back together.
    Merging compares elements to maintain order.
    Time complexity is O(n log n).
*/

import java.util.*;

class MergeSortPrices {

    // Recursively divide the array
    public static void mergeSort(int[] arr, int left, int right) {

        if (left >= right)
            return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);     // Sort left half
        mergeSort(arr, mid + 1, right); // Sort right half

        merge(arr, left, mid, right); // Merge sorted halves
    }

    // Merge two sorted halves
    private static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data into temporary arrays
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Compare and merge elements
        while (i < n1 && j < n2) {

            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from leftArr
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements from rightArr
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    // Main method to test
    public static void main(String[] args) {

        int[] prices = {450, 120, 999, 299, 650, 199};

        System.out.println("Original Prices: " + Arrays.toString(prices));

        mergeSort(prices, 0, prices.length - 1);

        System.out.println("Sorted Prices: " + Arrays.toString(prices));
    }
}

