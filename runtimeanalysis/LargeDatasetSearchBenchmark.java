package runtimeanalysis;
/*
 * LargeDatasetSearchBenchmark demonstrates and compares
 * the performance of Linear Search and Binary Search
 * on datasets of different sizes.
 * It highlights how Binary Search scales better for large sorted data.
 */

import java.util.Arrays;

public class LargeDatasetSearchBenchmark {

    // Performs Linear Search by checking each element sequentially
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Performs Binary Search on a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents integer overflow

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // Generates a sorted dataset from 1 to N
    public static int[] generateDataset(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i + 1;
        }
        return data;
    }

    // Measures execution time in nanoseconds for better precision
    public static long measureLinearSearch(int[] data, int target) {
        long start = System.nanoTime();
        linearSearch(data, target);
        return System.nanoTime() - start;
    }

    // Measures execution time for Binary Search
    public static long measureBinarySearch(int[] data, int target) {
        long start = System.nanoTime();
        binarySearch(data, target);
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 1000000};

        System.out.printf("%-15s %-20s %-20s%n", "Dataset Size", "Linear Search", "Binary Search");

        for (int size : sizes) {

            int[] dataset = generateDataset(size);
            int target = size; // Worst-case scenario for Linear Search

            long linearTime = measureLinearSearch(dataset, target);
            long binaryTime = measureBinarySearch(dataset, target);

            System.out.printf(
                    "%-15d %-20d %-20d%n",
                    size,
                    linearTime,
                    binaryTime
            );
        }
    }
}
