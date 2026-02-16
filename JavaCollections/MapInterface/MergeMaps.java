package MapInterface;

import java.util.*;

public class MergeMaps {
    static Map<String,Integer> merge(Map<String,Integer> a, Map<String,Integer> b){
        Map<String,Integer> res = new HashMap<>(a);
        for (var e: b.entrySet())
            res.put(e.getKey(), res.getOrDefault(e.getKey(),0) + e.getValue());
        return res;
    }

    public static void main(String[] args){
        Map<String,Integer> m1 = new HashMap<>();
        m1.put("A",1); m1.put("B",2);

        Map<String,Integer> m2 = new HashMap<>();
        m2.put("B",3); m2.put("C",4);

        System.out.println(merge(m1,m2)); // {A=1, B=5, C=4}
    }
}