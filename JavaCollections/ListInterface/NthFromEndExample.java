/*Find the Nth Element from the End
Given a singly linked list (use LinkedList), find the Nth element from the end without
calculating its size.
Example:
Input: [A, B, C, D, E], N=2 → Output: D.
*/

package JavaCollections.ListInterface;
import java.util.*;
import java.util.Iterator;
import java.util.LinkedList;

public class NthFromEndExample {

    // Method to find Nth element from end
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {

        // Edge case: invalid N
        if (n <= 0) {
            return null;
        }

        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        // Move fast pointer n steps ahead
        int count = 0;
        while (count < n) {

            if (!fast.hasNext()) {
                // If n is larger than list size
                return null;
            }

            fast.next();
            count++;
        }

        // Move both pointers until fast reaches end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        // slow now points to Nth from end
        return slow.next();
    }

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println("LinkedList: " + list);

        int n = 2;

        String result = findNthFromEnd(list, n);

        if (result != null) {
            System.out.println(n + "th element from end: " + result);
        } else {
            System.out.println("Invalid N value.");
        }
    }
}
