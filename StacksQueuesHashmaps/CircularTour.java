package stackqueuehashmap;
/*
    Circular Tour Problem using Queue.
    Each petrol pump provides some petrol and requires some to reach next pump.
    We simulate the tour using a queue and track current surplus petrol.
    If surplus becomes negative, remove pumps from the front.
    Continue until a valid starting point is found or all options fail.
    Time complexity is O(n).
*/

import java.util.*;

class CircularTour {

    // Find starting petrol pump index
    public static int findStart(int[] petrol, int[] distance) {

        int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>();

        int start = 0;
        int surplus = 0;
        int count = 0;

        while (count < 2 * n) {

            int i = count % n;

            queue.offer(i); // Add pump to tour
            surplus += petrol[i] - distance[i];

            // If surplus is negative, remove pumps from front
            while (surplus < 0 && !queue.isEmpty()) {
                int removed = queue.poll();
                surplus -= (petrol[removed] - distance[removed]);
                start = removed + 1;
            }

            // If queue size equals n, full tour is possible
            if (queue.size() == n) {
                return start % n;
            }

            count++;
        }

        return -1; // No possible tour
    }

    // Main method to test
    public static void main(String[] args) {

        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStart(petrol, distance);

        if (start != -1)
            System.out.println("Start from petrol pump index: " + start);
        else
            System.out.println("No possible circular tour.");
    }
}
