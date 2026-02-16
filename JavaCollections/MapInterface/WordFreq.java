package MapInterface;

import java.util.*;

public class WordFreq {
    static Map<String,Integer> count(String text){
        Map<String,Integer> m = new HashMap<>();
        for(String w: text.toLowerCase().replaceAll("[^a-z0-9\\s]"," ").split("\\s+")){
            if(!w.isEmpty()) m.put(w, m.getOrDefault(w,0)+1);
        }
        return m;
    }

    public static void main(String[] args){
        System.out.println(count("Hello world, hello Java!")); // {hello=2, world=1, java=1}
    }
}