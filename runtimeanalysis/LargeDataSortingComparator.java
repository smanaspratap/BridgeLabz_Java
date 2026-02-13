package runtimeanalysis;

/*
 * LargeDataSortingComparator compares Bubble Sort, Merge Sort,
 * and Quick Sort on datasets of different sizes.
 * It demonstrates why quadratic algorithms are unsuitable
 * for large-scale data processing.
 */

import java.util.Random;

public class LargeDataSortingComparator {

    // Simple but inefficient sorting algorithm with O(N^2) complexity
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break; // Stops early if array is already sorted
        }
    }

    // Stable divide and conquer sorting algorithm
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2; // Prevents overflow
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    // Merges two sorted halves
    private static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length); // Faster bulk copy than manual loop
    }

    // Quick Sort using Lomuto partition scheme
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // Places pivot at correct position
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partitions array around pivot (last element)
    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Generates random dataset to simulate real-world unsorted data
    public static int[] generateDataset(int size) {
        Random rand = new Random();
        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(size);
        }
        return data;
    }

    // Creates a copy so each algorithm runs on identical data
    public static int[] copyArray(int[] original) {
        return original.clone();
    }

    // Measures Bubble Sort time
    public static long measureBubbleSort(int[] arr) {
        long start = System.nanoTime();
        bubbleSort(arr);
        return System.nanoTime() - start;
    }

    // Measures Merge Sort time
    public static long measureMergeSort(int[] arr) {
        long start = System.nanoTime();
        mergeSort(arr, 0, arr.length - 1);
        return System.nanoTime() - start;
    }

    // Measures Quick Sort time
    public static long measureQuickSort(int[] arr) {
        long start = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 100000}; // Avoid extremely large Bubble Sort runtime

        System.out.printf("%-15s %-20s %-20s %-20s%n",
                "Dataset Size", "Bubble Sort", "Merge Sort", "Quick Sort");

        for (int size : sizes) {

            int[] dataset = generateDataset(size);

            int[] bubbleData = copyArray(dataset);
            int[] mergeData = copyArray(dataset);
            int[] quickData = copyArray(dataset);

            long bubbleTime = measureBubbleSort(bubbleData);
            long mergeTime = measureMergeSort(mergeData);
            long quickTime = measureQuickSort(quickData);

            System.out.printf("%-15d %-20d %-20d %-20d%n",
                    size, bubbleTime, mergeTime, quickTime);
        }
    }
}

