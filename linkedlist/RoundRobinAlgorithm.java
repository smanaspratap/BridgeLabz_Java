/*6. Circular Linked List: Round Robin Scheduling Algorithm
Problem Statement: Implement a round-robin CPU scheduling algorithm using a circular linked list. Each node will represent a process and contain Process ID, Burst Time, and Priority. Implement the following functionalities:
Add a new process at the end of the circular list.
Remove a process by Process ID after its execution.
Simulate the scheduling of processes in a round-robin manner with a fixed time quantum.
Display the list of processes in the circular queue after each round.
Calculate and display the average waiting time and turn-around time for all processes.
Hint:
Use a circular linked list to represent a queue of processes.
Each process executes for a fixed time quantum, and then control moves to the next process in the circular list.
Maintain the current node as the process being executed, and after each round, update the list to simulate execution.
*/
class Process {
    int pid;
    int burstTime;
    int remainingTime;
    Process next;

    Process(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.next = null;
    }
}
class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;

    RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add process at end
    void addProcess(int pid, int burstTime) {
        Process p = new Process(pid, burstTime);
        if (head == null) {
            head = tail = p;
            tail.next = head;
        } else {
            tail.next = p;
            p.next = head;
            tail = p;
        }
    }

    // Remove process by PID
    void removeProcess(int pid) {
        if (head == null) return;

        Process curr = head, prev = tail;
        do {
            if (curr.pid == pid) {
                if (curr == head) head = head.next;
                if (curr == tail) tail = prev;
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Simulate Round Robin
    void schedule() {
        if (head == null) return;

        int time = 0;
        Process curr = head;

        while (head != null) {
            System.out.println("\nExecuting Process " + curr.pid);

            int execTime = Math.min(timeQuantum, curr.remainingTime);
            curr.remainingTime -= execTime;
            time += execTime;

            displayProcesses();

            Process nextProcess = curr.next;

            if (curr.remainingTime == 0) {
                System.out.println("Process " + curr.pid + " completed.");
                removeProcess(curr.pid);
            }

            curr = nextProcess;
            if (head == null) break;
        }
    }

    void displayProcesses() {
        if (head == null) {
            System.out.println("No active processes.");
            return;
        }

        Process temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print("[PID:" + temp.pid +
                    " RT:" + temp.remainingTime + "] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}
