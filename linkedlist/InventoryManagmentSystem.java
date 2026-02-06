public class InventoryManagmentSystem {

    private Node head;
    private Node tail;
    private int size;

    InventoryManagmentSystem() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Node of Singly Linked List
    private class Node {
        String itemName;
        int itemId;
        int quantity;
        double price;
        Node next;

        Node(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
        }
    }

    /* ================= ADD OPERATIONS ================= */

    public void addAtBeginning(String name, int id, int qty, double price) {
        Node node = new Node(name, id, qty, price);
        node.next = head;
        head = node;

        if (tail == null) tail = head;
        size++;
    }

    public void addAtEnd(String name, int id, int qty, double price) {
        Node node = new Node(name, id, qty, price);

        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            addAtBeginning(name, id, qty, price);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        Node node = new Node(name, id, qty, price);
        node.next = temp.next;
        temp.next = node;

        if (node.next == null) tail = node;
        size++;
    }

    /* ================= REMOVE ================= */

    public void removeByItemId(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            size--;
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.itemId == id) {
                prev.next = curr.next;
                if (curr == tail) tail = prev;
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    /* ================= UPDATE ================= */

    public void updateQuantity(int id, int newQty) {
        Node temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    /* ================= SEARCH ================= */

    public void searchByItemId(int id) {
        Node temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    public void searchByItemName(String name) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("Item not found");
    }

    /* ================= TOTAL VALUE ================= */

    public double totalInventoryValue() {
        double total = 0;
        Node temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        return total;
    }

    /* ================= SORTING (MERGE SORT) ================= */

    public void sortByName(boolean ascending) {
        head = mergeSort(head, ascending, true);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, ascending, false);
    }

    private Node mergeSort(Node head, boolean asc, boolean sortByName) {
        if (head == null || head.next == null) return head;

        Node mid = getMid(head);
        Node right = mid.next;
        mid.next = null;

        Node leftSorted = mergeSort(head, asc, sortByName);
        Node rightSorted = mergeSort(right, asc, sortByName);

        return merge(leftSorted, rightSorted, asc, sortByName);
    }

    private Node merge(Node a, Node b, boolean asc, boolean sortByName) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (sortByName) {
            condition = asc ?
                    a.itemName.compareToIgnoreCase(b.itemName) <= 0 :
                    a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            a.next = merge(a.next, b, asc, sortByName);
            return a;
        } else {
            b.next = merge(a, b.next, asc, sortByName);
            return b;
        }
    }

    private Node getMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /* ================= DISPLAY ================= */

    public void displayInventory() {
        Node temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(Node n) {
        System.out.println(
                "ID: " + n.itemId +
                        ", Name: " + n.itemName +
                        ", Qty: " + n.quantity +
                        ", Price: " + n.price
        );
    }
}
