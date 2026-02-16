/*Check if Two Sets Are Equal
Compare two sets and determine if they contain the same elements, regardless of order.
Example:
Set1: {1, 2, 3}, Set2: {3, 2, 1} → Output: true.*/
package JavaCollections.SetInterface;
import java.util.*;
public class EqualSets {
    public static <T> boolean twoequalset(Set<T> set1, Set<T> set2){
        //If Size are not Equal.
        if(set1.size() != set2.size()){
            return false;
        }
        for(T element: set1){
            if(!set2.contains(element)){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {

        // Creating first set
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // Creating second set
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Using manual method
        boolean result = twoequalset(set1, set2);

        System.out.println("Are sets equal (manual)? " + result);

        // Using built-in equals method
        System.out.println("Are sets equal (built-in)? " + set1.equals(set2));
    }
}

