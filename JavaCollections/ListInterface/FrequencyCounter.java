/*Find Frequency of Elements
Given a list of strings, count the frequency of each element and return the results in a
Map<String, Integer>.
Example:
Input: ["apple", "banana", "apple", "orange"] → Output: {apple=2, banana=1, orange=1}.
*/

package JavaCollections.ListInterface;
import java.util.*;
public class FrequencyCounter {
    //Method to count frequency of elements in a List
    public static Map<String, Integer> countInteger(List<String> list){
        Map<String, Integer> freqmap = new HashMap<>();
        for(String item : list){
            //If the map contains the item already.
            if(freqmap.containsKey(item)){
                //Increase the count by 1.
                freqmap.put(item, freqmap.get(item)+1);
            }else{
                //If not
                freqmap.put(item, 1);

            }

        }
        return freqmap;
    }

    static void main(String[] args) {
        //Creating the sample list
        List<String>fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Pineapple");
        fruits.add("apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("apple");

        System.out.println("Input List: " + fruits);

        Map<String, Integer> result = countInteger(fruits);
        System.out.println("Frequency map:" +result);

    }
}
