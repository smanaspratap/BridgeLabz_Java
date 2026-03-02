package MultiThreading;
/*Problem Statement 1: "Simple Threaded Counter
Background:
You are tasked with creating a simple threaded counter program that counts from 1 to a
specified limit concurrently using multiple threads.*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Simple Threaded Counter
 *
 * Usage:
 *   javac ThreadedCounter.java
 *   java ThreadedCounter
 *
 * The program will prompt: "Enter the counting limit (positive integer):"
 * Enter a positive integer N; the program will print numbers 1..N using multiple threads,
 * while preserving the exact overall order.
 */
class ThreadedCounter {

    /**
     * Coordinator used by all threads to ensure printing happens in exact sequence.
     * Threads call printWhenTurn(k, threadName) for each number they are responsible for.
     */
    static class PrintCoordinator {
        private int nextToPrint = 1;           // next number that should be printed
        private final int limit;

        public PrintCoordinator(int limit) {
            this.limit = limit;
        }

        /**
         * Print number 'k' only when it's the global nextToPrint.
         * Blocks (using wait()) until it's this number's turn.
         *
         * @param k          the number the calling thread wants to print
         * @param threadName the thread's name (for logging)
         * @throws InterruptedException if thread is interrupted while waiting
         */
        public synchronized void printWhenTurn(int k, String threadName) throws InterruptedException {
            // Basic safety: don't allow printing outside 1..limit
            if (k < 1 || k > limit) return;

            // Wait until it's this number's turn
            while (nextToPrint != k) {
                wait();
            }

            // It's our turn: print the number (include thread id/name for clarity)
            System.out.printf("Thread %-2s printed: %d%n", threadName, k);

            // Advance nextToPrint and wake up waiting threads
            nextToPrint++;
            notifyAll();
        }
    }

    /**
     * Runnable that counts a contiguous subrange [start, end] and asks the coordinator
     * to print each number when it becomes the global turn.
     */
    static class RangeCounter implements Runnable {
        private final int start;
        private final int end;
        private final PrintCoordinator coordinator;
        private final String name;

        public RangeCounter(int start, int end, PrintCoordinator coordinator, String name) {
            this.start = start;
            this.end = end;
            this.coordinator = coordinator;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                for (int k = start; k <= end; k++) {
                    // Ask coordinator to print when it's k's turn
                    coordinator.printWhenTurn(k, name);
                    // (Optional) simulate small work / context switches:
                    // Thread.yield();
                }
            } catch (InterruptedException e) {
                // If interrupted, print a message and exit gracefully
                System.err.printf("Thread %s interrupted.%n", name);
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Partition 1..limit into `numParts` contiguous chunks.
     *
     * Example: limit=10, numParts=3 -> ranges:
     *   [1..4], [5..7], [8..10]
     *
     * Returns a list of int[2] arrays where [0]=start, [1]=end
     */
    private static List<int[]> partitionRange(int limit, int numParts) {
        List<int[]> parts = new ArrayList<>(numParts);
        int base = limit / numParts;
        int remainder = limit % numParts; // distribute +1 to first `remainder` parts

        int current = 1;
        for (int i = 0; i < numParts; i++) {
            int extra = (i < remainder) ? 1 : 0;
            int partSize = base + extra;
            int start = current;
            int end = Math.max(current + partSize - 1, current - 1); // if partSize==0, end < start
            if (partSize > 0) {
                parts.add(new int[]{start, end});
                current = end + 1;
            } else {
                // no items for this part; still add an empty range
                parts.add(new int[]{start, start - 1}); // empty range
            }
        }
        return parts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the counting limit (positive integer): ");

        int limit;
        try {
            String line = scanner.nextLine().trim();
            limit = Integer.parseInt(line);
            if (limit <= 0) {
                System.err.println("Error: Please enter a positive integer greater than 0.");
                return;
            }
        } catch (NumberFormatException nfe) {
            System.err.println("Error: Invalid integer input. Please run again and enter a positive integer.");
            return;
        }

        // Determine number of worker threads: at most 'limit', and prefer number of available processors.
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int numThreads = Math.min(limit, availableProcessors); // do not create more threads than numbers to print

        System.out.printf("Counting to %d using %d thread(s) (available processors: %d)%n",
                limit, numThreads, availableProcessors);

        PrintCoordinator coordinator = new PrintCoordinator(limit);

        // Partition the [1..limit] range among threads
        List<int[]> ranges = partitionRange(limit, numThreads);

        // Create and start threads
        List<Thread> threads = new ArrayList<>(numThreads);
        for (int i = 0; i < numThreads; i++) {
            int[] r = ranges.get(i);
            int start = r[0];
            int end = r[1];
            String threadName = "T" + (i + 1);

            // If this range is empty (start > end), we still create a thread that does nothing or skip it.
            if (start > end) {
                // skip creating an idle thread for empty range
                continue;
            }

            RangeCounter task = new RangeCounter(start, end, coordinator, threadName);
            Thread t = new Thread(task, threadName);
            threads.add(t);
            t.start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.err.println("Main thread interrupted while waiting for workers.");
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Counting complete.");
    }
}