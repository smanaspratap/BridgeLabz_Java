package QueueInterface;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Reverse{
    public static Queue<Integer> reverse(Queue<Integer> arr){
        Queue<Integer> res = new LinkedList<>();
        //int tail = arr.toArray().length-1;
        Integer[] temp = arr.toArray(new Integer [0]);

        for(int i=temp.length-1; i>=0; i--){
            res.add((temp[i]));
        }
        return res;
    }

}

public class ReverseQueue {
    public static void main (String[] args){
        Queue<Integer> arr = new LinkedList<>();
        arr.add(1);
        arr.add(3);
        arr.add(30);
        System.out.println(Reverse.reverse(arr));
    }
}
