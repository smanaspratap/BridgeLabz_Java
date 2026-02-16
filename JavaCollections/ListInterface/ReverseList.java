/*Reverse a List
Write a program to reverse the elements of a given List without using built-in reverse methods.
Implement it for both ArrayList and LinkedList.
Example:
Input: [1, 2, 3, 4, 5] → Output: [5, 4, 3, 2, 1].
*/

package JavaCollections.ListInterface;
import java.util.*;


public class ReverseList {

    //Method to reverse a list manually
    public static <T> void reverseList(List<T> list){
        //Use the two pointer method
        int left = 0;
        int right = list.size()-1;
        //Swap the elements using the two pointers.
        while(left<right){
            //Store the value of the left
            T temp = list.get(left);
            //Replace Left with the Right
            list.set(left, list.get(right));
            //Replace right with temp
            list.set(right, temp);
            left++;
            right--;

        }
    }

    static void main(String[] args) {
        //ArrayList
        ArrayList<Integer>arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println("Original ArrayList" +arrayList);
        reverseList(arrayList);
        System.out.println("Reversed ArrayList:" + arrayList);

        //LinkedList
        LinkedList<Integer> LL = new LinkedList<>();
        LL.add(1);
        LL.add(2);
        LL.add(3);
        LL.add(4);
        System.out.println("Original LinkedList" + LL);
        reverseList(LL);
        System.out.println("Reversed LinkedList:" + LL);



    }
}
