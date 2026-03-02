package MultiThreading;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Producer-Consumer Problem using wait() and notifyAll()
 *
 * One Producer thread generates integer tasks.
 * One Consumer thread consumes tasks from a shared queue.
 *
 * The shared queue has a fixed capacity (bounded buffer).
 */
public class ProducerConsumer{

    /**
     * Shared Resource (Bounded Buffer)
     */
    static class SharedQueue {

        private final Queue<Integer> queue = new LinkedList<>();
        private final int capacity;

        public SharedQueue(int capacity) {
            this.capacity = capacity;
        }

        /**
         * Producer adds task to queue
         */
        public synchronized void produce(int value) throws InterruptedException {

            // If queue is full, wait until consumer consumes
            while (queue.size() == capacity) {
                System.out.println("Queue is full. Producer waiting...");
                wait(); // release lock and wait
            }

            queue.add(value);
            System.out.println("Produced: " + value);

            // Notify consumer that new item is available
            notifyAll();
        }

        /**
         * Consumer removes task from queue
         */
        public synchronized int consume() throws InterruptedException {

            // If queue is empty, wait until producer produces
            while (queue.isEmpty()) {
                System.out.println("Queue is empty. Consumer waiting...");
                wait(); // release lock and wait
            }

            int value = queue.remove();
            System.out.println("Consumed: " + value);

            // Notify producer that space is available
            notifyAll();

            return value;
        }
    }

    /**
     * Producer Thread
     */
    static class Producer implements Runnable {

        private final SharedQueue sharedQueue;
        private final int totalTasks;

        public Producer(SharedQueue sharedQueue, int totalTasks) {
            this.sharedQueue = sharedQueue;
            this.totalTasks = totalTasks;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= totalTasks; i++) {

                    sharedQueue.produce(i);

                    // Simulate time taken to produce task
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.err.println("Producer interrupted.");
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                System.err.println("Unexpected error in Producer: " + e.getMessage());
            }
        }
    }

    /**
     * Consumer Thread
     */
    static class Consumer implements Runnable {

        private final SharedQueue sharedQueue;
        private final int totalTasks;

        public Consumer(SharedQueue sharedQueue, int totalTasks) {
            this.sharedQueue = sharedQueue;
            this.totalTasks = totalTasks;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= totalTasks; i++) {

                    sharedQueue.consume();

                    // Simulate time taken to process task
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                System.err.println("Consumer interrupted.");
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                System.err.println("Unexpected error in Consumer: " + e.getMessage());
            }
        }
    }

    /**
     * Main Method
     */
    public static void main(String[] args) {

        try {
            int bufferCapacity = 5;   // max size of queue
            int totalTasks = 10;      // total tasks to produce/consume

            SharedQueue sharedQueue = new SharedQueue(bufferCapacity);

            Thread producerThread = new Thread(new Producer(sharedQueue, totalTasks));
            Thread consumerThread = new Thread(new Consumer(sharedQueue, totalTasks));

            producerThread.start();
            consumerThread.start();

            producerThread.join();
            consumerThread.join();

            System.out.println("All tasks produced and consumed successfully.");

        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted.");
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println("Unexpected error in Main: " + e.getMessage());
        }
    }
}
