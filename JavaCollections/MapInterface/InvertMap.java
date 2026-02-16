package MapInterface;

import java.util.*;

public class InvertMap {
    static <K,V> Map<V,List<K>> invert(Map<K,V> map){
        Map<V,List<K>> res = new HashMap<>();
        for (var e: map.entrySet())
            res.computeIfAbsent(e.getValue(), k -> new ArrayList<>()).add(e.getKey());
        return res;
    }

    public static void main(String[] args){
        Map<String,Integer> input = new HashMap<>();
        input.put("A",1); input.put("B",2); input.put("C",1);

        System.out.println(invert(input)); // {1=[A, C], 2=[B]}
    }
}