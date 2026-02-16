/*Union and Intersection of Two Sets
Given two sets, compute their union and intersection.
Example:
Set1: {1, 2, 3}, Set2: {3, 4, 5} → Union: {1, 2, 3, 4, 5}, Intersection: {3}.
*/
package JavaCollections.SetInterface;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class UnionIntersection {

    // Method to find Union
    public static <T> Set<T> findUnion(Set<T> set1, Set<T> set2) {

        // Create new set to store union
        Set<T> union = new HashSet<>();

        // Add all elements from set1
        for (T element : set1) {
            union.add(element);
        }

        // Add all elements from set2
        for (T element : set2) {
            union.add(element);
        }

        return union;
    }

    // Method to find Intersection
    public static <T> Set<T> findIntersection(Set<T> set1, Set<T> set2) {

        Set<T> intersection = new HashSet<>();

        // Check common elements
        for (T element : set1) {

            if (set2.contains(element)) {
                intersection.add(element);
            }
        }

        return intersection;
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

        Set<Integer> union = findUnion(set1, set2);
        Set<Integer> intersection = findIntersection(set1, set2);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}

