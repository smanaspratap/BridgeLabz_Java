package stackqueuehashmap;

/*
    Custom HashMap implementation using Separate Chaining.
    We use an array of LinkedLists to store key-value pairs.
    Collisions are handled by inserting nodes into the same bucket.
    Hash function maps keys to bucket indices.
    Supports put, get, and remove operations.
    Average time complexity is O(1).
*/

import java.util.*;

class CustomHashMap<K, V> {

    // Node class to store key-value pairs
    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 16;
    private LinkedList<Node>[] buckets;

    // Initialize bucket array
    public CustomHashMap() {
        buckets = new LinkedList[capacity];

        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Generate bucket index from key
    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Insert or update key-value pair
    public void put(K key, V value) {

        int index = getIndex(key);
        LinkedList<Node> bucket = buckets[index];

        // Check if key already exists
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; // Update value
                return;
            }
        }

        bucket.add(new Node(key, value)); // Insert new node
    }

    // Retrieve value by key
    public V get(K key) {

        int index = getIndex(key);
        LinkedList<Node> bucket = buckets[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null; // Key not found
    }

    // Remove key-value pair
    public void remove(K key) {

        int index = getIndex(key);
        LinkedList<Node> bucket = buckets[index];

        Iterator<Node> iterator = bucket.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().key.equals(key)) {
                iterator.remove();
                return;
            }
        }
    }

    // Main method to test
    public static void main(String[] args) {

        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Mango", 30);

        System.out.println("Apple value: " + map.get("Apple"));

        map.put("Apple", 50); // Update value
        System.out.println("Updated Apple value: " + map.get("Apple"));

        map.remove("Banana");
        System.out.println("Banana value after removal: " + map.get("Banana"));
    }
}

