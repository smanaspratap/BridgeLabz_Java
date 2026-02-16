/*Find Subsets
Check if one set is a subset of another.
Example:
Set1: {2, 3}, Set2: {1, 2, 3, 4} → Output: true.
*/

package JavaCollections.SetInterface;

import java.util.HashSet;
import java.util.Set;

class SubsetExample {

    // Method to check if set1 is subset of set2
    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {

        // Check every element of set1
        for (T element : set1) {

            // If element not found in set2
            if (!set2.contains(element)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        boolean result = isSubset(set1, set2);

        System.out.println("Is Set1 a subset of Set2? " + result);

        // Built-in shortcut
        System.out.println("Using containsAll(): " + set2.containsAll(set1));
    }
}
