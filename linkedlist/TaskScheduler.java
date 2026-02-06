/*3. Circular Linked List: Task Scheduler
Problem Statement: Create a task scheduler using a circular linked list. Each node in the list represents a task with Task ID, Task Name, Priority, and Due Date. Implement the following functionalities:
Add a task at the beginning, end, or at a specific position in the circular list.
Remove a task by Task ID.
View the current task and move to the next task in the circular list.
Display all tasks in the list starting from the head node.
Search for a task by Priority.
Hint:
Use a circular linked list where the last node’s next pointer points back to the first node, creating a circular structure.
Ensure that the list loops when traversed from the head node, so tasks can be revisited in a circular manner.
When deleting or adding tasks, maintain the circular nature by updating the appropriate next pointers. */

import java.time.LocalDate;

public class TaskScheduler {

    private Node head;
    private Node current;
    private int size;

    TaskScheduler() {
        this.head = null;
        this.current = null;
        this.size = 0;
    }

    // Node of Circular Linked List
    private class Node {
        int taskId;
        String taskName;
        int priority;
        LocalDate dueDate;
        Node next;

        Node(int taskId, String taskName, int priority, LocalDate dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }

    /* ================= ADD OPERATIONS ================= */

    // Add at beginning
    public void addAtBeginning(int id, String name, int priority, LocalDate dueDate) {
        Node node = new Node(id, name, priority, dueDate);

        if (head == null) {
            head = node;
            node.next = head;
            current = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            node.next = head;
            temp.next = node;
            head = node;
        }
        size++;
    }

    // Add at end
    public void addAtEnd(int id, String name, int priority, LocalDate dueDate) {
        Node node = new Node(id, name, priority, dueDate);

        if (head == null) {
            head = node;
            node.next = head;
            current = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = head;
        }
        size++;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int pos, int id, String name, int priority, LocalDate dueDate) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Node node = new Node(id, name, priority, dueDate);
        Node temp = head;

        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }

    /* ================= REMOVE OPERATION ================= */

    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Node curr = head;
        Node prev = null;

        do {
            if (curr.taskId == taskId) {
                if (prev == null) { // deleting head
                    Node last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                size--;
                System.out.println("Task removed successfully");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Task ID not found");
    }

    /* ================= TASK NAVIGATION ================= */

    // View current task and move to next
    public void viewNextTask() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }

        System.out.println("Current Task:");
        displayTask(current);
        current = current.next;
    }

    /* ================= DISPLAY ================= */

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Node temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    private void displayTask(Node node) {
        System.out.println("Task ID: " + node.taskId +
                ", Name: " + node.taskName +
                ", Priority: " + node.priority +
                ", Due Date: " + node.dueDate);
    }

    /* ================= SEARCH ================= */

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Node temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}
class task {
    public static void main(String[] args) {

        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks at end
        scheduler.addAtEnd(101, "Write Report", 1, LocalDate.of(2026, 2, 10));
        scheduler.addAtEnd(102, "Prepare Slides", 2, LocalDate.of(2026, 2, 12));

        // Add task at beginning
        scheduler.addAtBeginning(100, "Daily Standup", 1, LocalDate.of(2026, 2, 6));

        // Add task at specific position
        scheduler.addAtPosition(2, 103, "Code Review", 2, LocalDate.of(2026, 2, 8));

        System.out.println("\n--- All Tasks ---");
        scheduler.displayAllTasks();

        // View current task and move circularly
        System.out.println("\n--- Circular Task Execution ---");
        scheduler.viewNextTask();
        scheduler.viewNextTask();
        scheduler.viewNextTask();
        scheduler.viewNextTask();

        // Search by priority
        System.out.println("\n--- Search Tasks with Priority 1 ---");
        scheduler.searchByPriority(1);

        // Remove task by ID
        System.out.println("\n--- Removing Task ID 102 ---");
        scheduler.removeByTaskId(102);

        System.out.println("\n--- Tasks After Removal ---");
        scheduler.displayAllTasks();
    }
}

