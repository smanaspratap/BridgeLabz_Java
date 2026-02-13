/*Linear Search Problem 1: Search for the First Negative Number
Problem:
You are given an integer array. Write a program that performs Linear Search to find the first negative number in the array. If a negative number is found, return its index. If no negative number is found, return -1.
Approach:
Iterate through the array from the start.
Check if the current element is negative.
If a negative number is found, return its index.
If the loop completes without finding a negative number, return -1.
*/
class FirstNegativeLinearSearch {

    // Method to find index of first negative number
    public static int findFirstNegative(int[] arr) {

        // If array is null or empty, return -1
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // Check if current element is negative
            if (arr[i] < 0) {
                return i;  // Return index immediately
            }
        }

        // If no negative number found
        return -1;
    }

    public static void main(String[] args) {

        int[] numbers = {5, 3, 8, -2, 7};

        int result = findFirstNegative(numbers);

        System.out.println("Index of first negative number: " + result);
    }
}

