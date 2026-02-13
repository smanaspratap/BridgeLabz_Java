/*Binary Search Problem 4: Find the First and Last Occurrence of an Element in a Sorted Array
Problem:
Given a sorted array and a target element, write a program that uses Binary Search to find the first and last occurrence of the target element in the array. If the element is not found, return -1.
Approach:
Use binary search to find the first occurrence:
Perform a regular binary search, but if the target is found, continue searching on the left side (right = mid - 1) to find the first occurrence.
Use binary search to find the last occurrence:
Similar to finding the first occurrence, but once the target is found, continue searching on the right side (left = mid + 1) to find the last occurrence.
Return the indices of the first and last occurrence. If not found, return -1.
*/

public class FirstandLastOcc {

    // Function to find first occurrence of target
    public static int findFirst(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int answer = -1; // default if not found

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // If target found
            if (arr[mid] == target) {
                answer = mid;      // store the index
                right = mid - 1;   // move LEFT to find earlier occurrence
            }

            // If target is greater, search right half
            else if (arr[mid] < target) {
                left = mid + 1;
            }

            // If target is smaller, search left half
            else {
                right = mid - 1;
            }
        }

        return answer;
    }

    // Function to find last occurrence of target
    public static int findLast(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int answer = -1; // default if not found

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // If target found
            if (arr[mid] == target) {
                answer = mid;     // store index
                left = mid + 1;   // move RIGHT to find later occurrence
            }

            // If target is greater, search right half
            else if (arr[mid] < target) {
                left = mid + 1;
            }

            // If target is smaller, search left half
            else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        if (first == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("First Occurrence: " + first);
            System.out.println("Last Occurrence: " + last);
        }
    }
}

