/*StringBuffer Problem 1: Concatenate Strings Efficiently Using StringBuffer
Problem:
You are given an array of strings. Write a program that uses StringBuffer to concatenate
all the strings in the array efficiently.
Approach:
Create a new StringBuffer object.
Iterate through each string in the array and append it to the StringBuffer.
Return the concatenated string after the loop finishes.
Using StringBuffer ensures efficient string concatenation due to its mutable nature.
*/

public class ConcatenateStrings {
    public static String Concatenate(String[]arr){
        //if array is empty return null
        if(arr == null){
            return null;
        }
        //Make a string to add it in there
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i]);
        }
        return str.toString();
    }
    public static void main(String[] args){
        String[] arr = {"Java", "is" ,"awesome"};
        String result = Concatenate(arr);
        System.out.println(result);
    }
}
