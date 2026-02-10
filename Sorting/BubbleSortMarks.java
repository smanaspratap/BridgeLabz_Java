package sorting;
/*
    Bubble Sort to arrange student marks in ascending order.
    Repeatedly compare adjacent elements and swap if they are in wrong order.
    After each pass, the largest element moves to the end.
    Stop early if no swaps occur in a pass (array already sorted).
    Simple but inefficient for large datasets.
    Time complexity is O(n^2).
*/

import java.util.*;

class BubbleSortMarks {

    // Perform bubble sort on marks array
    public static void bubbleSort(int[] marks) {

        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {

            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                // Swap if current element is greater than next
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // Stop if already sorted
            if (!swapped)
                break;
        }
    }

    // Main method to test
    public static void main(String[] args) {

        int[] marks = {78, 45, 90, 62, 84, 55};

        System.out.println("Original Marks: " + Arrays.toString(marks));

        bubbleSort(marks);

        System.out.println("Sorted Marks: " + Arrays.toString(marks));
    }
}
