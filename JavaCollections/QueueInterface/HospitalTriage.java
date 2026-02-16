package QueueInterface;

import java.util.Comparator;
import java.util.PriorityQueue;

class Patient{
    String name;
    int severity;
    int arrival;
    Patient(String name , int severity , int arrival){
        this.arrival=arrival;
        this.severity=severity;
        this.name=name;
    }
}

public class HospitalTriage {
    public static void main(String[] args){
        Comparator<Patient> comparator = (a,b)->{
            if(a.severity!=b.severity)return Integer.compare(b.severity,a.severity);
            return Integer.compare(a.arrival,b.arrival);
        };

        PriorityQueue<Patient> pq= new PriorityQueue<>(comparator);
        int t = 0;
        pq.add(new Patient("John", 3, t++));
        pq.add(new Patient("Alice", 5, t++));
        pq.add(new Patient("Bob", 2, t++));

        while (!pq.isEmpty()) {
            Patient p = pq.poll();
            System.out.println(p.name + " (severity " + p.severity + ")");
        }
    }
}
