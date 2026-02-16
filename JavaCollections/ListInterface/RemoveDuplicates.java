/*Remove Duplicates While Preserving Order
Remove duplicate elements from a list while maintaining the original order of elements.
Example:
Input: [3, 1, 2, 2, 3, 4] → Output: [3, 1, 2, 4].*/

package JavaCollections.ListInterface;
import java.util.*;
public class RemoveDuplicates {
    public static <T> List<T> removeDups(List<T>list){
        //What's already seen
        Set<T>seen  = new HashSet<>();
        //New List to store the result
        List<T> result = new ArrayList<>();
        //We traverse the original list
        for(T element : list){
            //if element is not seen
            if(!seen.contains(element)){
                seen.add(element);
                result.add(element);
            }

        }
        return result;

    }
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        System.out.println("Original List: " + numbers);

        List<Integer> uniqueList = removeDups(numbers);

        System.out.println("List after removing duplicates: " + uniqueList);
    }
}

