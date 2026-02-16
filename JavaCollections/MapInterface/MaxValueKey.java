package MapInterface;

import java.util.*;

public class MaxValueKey {
    static String maxKey(Map<String,Integer> m){
        String ans = null;
        int best = Integer.MIN_VALUE;
        for (var e: m.entrySet()){
            if (e.getValue() > best){
                best = e.getValue();
                ans = e.getKey();
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Map<String,Integer> m = new HashMap<>();
        m.put("A",10); m.put("B",20); m.put("C",15);

        System.out.println(maxKey(m)); // B
    }
}
