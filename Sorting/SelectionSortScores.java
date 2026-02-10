package sorting;

/*
    Selection Sort to arrange exam scores in ascending order.
    Repeatedly find the minimum element from the unsorted part.
    Swap it with the first unsorted position.
    The sorted portion grows from left to right.
    Performs fewer swaps compared to Bubble Sort.
    Time complexity is O(n^2).
*/

import java.util.*;

class SelectionSortScores {

    // Perform selection sort on scores
    public static void selectionSort(int[] scores) {

        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            // Find index of minimum element
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap minimum with current position
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Main method to test
    public static void main(String[] args) {

        int[] scores = {88, 73, 92, 65, 81, 70};

        System.out.println("Original Scores: " + Arrays.toString(scores));

        selectionSort(scores);

        System.out.println("Sorted Scores: " + Arrays.toString(scores));
    }
}

