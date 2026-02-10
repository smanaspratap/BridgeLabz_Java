package sorting;

/*
    Heap Sort to arrange salary demands in ascending order.
    First build a Max Heap so the largest element is at the root.
    Swap the root with the last element and reduce heap size.
    Heapify again to maintain heap property.
    Repeat until all elements are sorted.
    Time complexity is O(n log n).
*/

import java.util.*;

class HeapSortSalaries {

    // Perform heap sort
    public static void heapSort(int[] arr) {

        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0); // Restore heap property
        }
    }

    // Ensure subtree follows max heap property
    private static void heapify(int[] arr, int size, int root) {

        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // Check left child
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check right child
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        // Swap and continue heapifying if root is not largest
        if (largest != root) {

            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            heapify(arr, size, largest);
        }
    }

    // Main method to test
    public static void main(String[] args) {

        int[] salaries = {55000, 72000, 48000, 91000, 60000, 53000};

        System.out.println("Original Salaries: " + Arrays.toString(salaries));

        heapSort(salaries);

        System.out.println("Sorted Salaries: " + Arrays.toString(salaries));
    }
}

