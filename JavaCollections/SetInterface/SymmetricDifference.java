/*Symmetric Difference
Find the symmetric difference (elements present in either set but not in both) of two sets.
Example:
Set1: {1, 2, 3}, Set2: {3, 4, 5} → Output: {1, 2, 4, 5}.
*/

package JavaCollections.SetInterface;

import java.util.HashSet;
import java.util.Set;

class SymmetricDifferenceExample {

    // Method to find symmetric difference
    public static <T> Set<T> findSymmetricDifference(Set<T> set1, Set<T> set2) {

        Set<T> result = new HashSet<>();

        // Elements in set1 but not in set2
        for (T element : set1) {
            if (!set2.contains(element)) {
                result.add(element);
            }
        }

        // Elements in set2 but not in set1
        for (T element : set2) {
            if (!set1.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        Set<Integer> symmetricDifference = findSymmetricDifference(set1, set2);

        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}
