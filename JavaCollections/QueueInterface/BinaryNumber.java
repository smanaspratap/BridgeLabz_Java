package QueueInterface;

import java.util.*;

public class BinaryNumber{

    public static List<String> generateBinary(int n) {
        if (n <= 0) return new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        List<String> result = new ArrayList<>(n);

        q.add("1");

        for (int i = 0; i < n; i++) {
            String s = q.remove();      // take front
            result.add(s);

            q.add(s + "0");             // next binary
            q.add(s + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(generateBinary(n)); // [1, 10, 11, 100, 101]
    }
}

