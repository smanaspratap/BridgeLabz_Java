/*Convert a Set to a Sorted List
Convert a HashSet of integers into a sorted list in ascending order.
Example:
Input: {5, 3, 9, 1} → Output: [1, 3, 5, 9].
*/

package JavaCollections.SetInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SetToSortedListExample {

    // Method to convert set to sorted list
    public static List<Integer> convertToSortedList(Set<Integer> set) {

        // Convert Set to List
        List<Integer> list = new ArrayList<>(set);

        // Sort the list in ascending order
        Collections.sort(list);

        return list;
    }

    public static void main(String[] args) {

        // Creating HashSet
        Set<Integer> numbers = new HashSet<>();
        numbers.add(5);
        numbers.add(3);
        numbers.add(9);
        numbers.add(1);

        System.out.println("Original Set: " + numbers);

        List<Integer> sortedList = convertToSortedList(numbers);

        System.out.println("Sorted List: " + sortedList);
    }
}
