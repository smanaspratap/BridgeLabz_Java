/*Rotate Elements in a List
Rotate the elements of a list by a given number of positions.
Example:
Input: [10, 20, 30, 40, 50], rotate by 2 → Output: [30, 40, 50, 10, 20].
*/
package JavaCollections.ListInterface;
import java.util.*;
class RotateElements {
    public static <T>void RotateList(List<T> list , int k){
        //k here is the position by which the array will be rotating.
        int n = list.size();
        //Edge Cases
        if(n == 0){
            //If the list is empty return
            return;
        }
        //Normalize the k in case if k> n.
        k = k%n;

        if(k==0){
            return;
        }
        //Store the first k elements in the list
        List<T>temp = new ArrayList<>();
        for(int i = 0; i<k; i++){
            temp.add(list.get(i));
        }
        //Shift the Remaining Element
        for(int i = k; i < n; i++){
            list.set(i-k, list.get(i));
        }
        //Now add the sorted elements
        for(int i = 0; i<k; i++){
            list.set(n-k+i, temp.get(i));
        }


    }

    static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        System.out.println("Original List: " + numbers);

        int k = 2;

        RotateList(numbers, k);

        System.out.println("List after rotating by " + k + " positions: " + numbers);
    }
}
