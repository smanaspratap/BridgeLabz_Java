/*Binary Search Problem 2: Find the Peak Element in an Array
Problem:
A peak element is an element that is greater than its neighbors. Write a program that performs Binary Search to find a peak element in an array. If there are multiple peak elements, return any one of them.
Approach:
Initialize left as 0 and right as n - 1.
Perform a binary search:
Find the middle element mid = (left + right) / 2.
If arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1], arr[mid] is a peak element.
If arr[mid] < arr[mid - 1], then search the left half, updating right = mid - 1.
If arr[mid] < arr[mid + 1], then search the right half, updating left = mid + 1.
Continue until a peak element is found.
*/

public class PeakElementinArray {
    public static int peakelement(int[]arr){
        int left = 0;
        int right = arr.length -1;
        int mid = left + (right - left) /2;
        while(left<right){
            //Two conditions to find the peak element
            if(arr[mid]<arr[mid+1]){
                left = mid +1;
            }
            //mid -1 is not there because the element might go to the other side of the mountain
            if(arr[mid]>arr[mid+1]){
                right = mid;
            }
            //update the mid element.
            mid = left + (right - left) /2;
        }
        return left;
    }
//Calling the method
    static void main(String[] args) {
        int[] arr = {1,72,3,4,5,12,32,21};
        int peak = peakelement(arr);
        System.out.println(arr[peak]);

    }
    
}
