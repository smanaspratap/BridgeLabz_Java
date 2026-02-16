package QueueInterface;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Stack{
    public static Integer queue(LinkedList<Integer> arr){


        Queue<Integer> res = new LinkedList<>();
        //int tail = arr.toArray().length-1;
        Integer[] temp = arr.toArray(new Integer [0]);

        for(int i=temp.length-1; i>=0; i--){
            res.add((temp[i]));
        }
        return res.remove();
    }
}

public class StackUsingQueue {

    public static void main (String[] args){
        LinkedList<Integer> arr = new LinkedList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        System.out.println(Stack.queue(arr));
    }
}
