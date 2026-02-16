package QueueInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Buffer{
    public static Queue<Integer> buffer(Queue<Integer> arr){
        int buff=0;
        Queue<Integer> res= new LinkedList<>();
        Integer[] temp = arr.toArray(new Integer [0]);

        for(int i=0; i<temp.length-1;i++){
            if(buff<3){
                res.add(temp[i]);
                buff++;
            }else{
                res.remove();
                buff--;
                res.add(temp[i]);
                buff++;
            }
        }
        return res;
    }
}

public class CircularBuffer {
    public static void main(String[] args){
        Queue<Integer> arr= new LinkedList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        System.out.println(Buffer.buffer(arr));
    }
}
