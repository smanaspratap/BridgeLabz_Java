package runtimeanalysis;
/*
 * DataStructureSearchPerformance compares search efficiency
 * across Array (linear search), HashSet (constant time),
 * and TreeSet (logarithmic time).
 * It demonstrates the trade-off between speed, memory, and ordering.
 */

import java.util.HashSet;
import java.util.TreeSet;

public class DataStructureSearchPerformance {

    // Linear search with O(N) complexity
    public static boolean arraySearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    // Average O(1) lookup using hashing
    public static boolean hashSetSearch(HashSet<Integer> set, int target) {
        return set.contains(target);
    }

    // Balanced Red-Black tree provides O(log N) search
    public static boolean treeSetSearch(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }

    // Generates sequential dataset
    public static int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // Converts array into HashSet
    public static HashSet<Integer> buildHashSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>(arr.length); // Pre-sizing avoids rehashing
        for (int num : arr) {
            set.add(num);
        }
        return set;
    }

    // Converts array into TreeSet
    public static TreeSet<Integer> buildTreeSet(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set;
    }

    // Measures array search time
    public static long measureArraySearch(int[] arr, int target) {
        long start = System.nanoTime();
        arraySearch(arr, target);
        return System.nanoTime() - start;
    }

    // Measures HashSet search time
    public static long measureHashSetSearch(HashSet<Integer> set, int target) {
        long start = System.nanoTime();
        hashSetSearch(set, target);
        return System.nanoTime() - start;
    }

    // Measures TreeSet search time
    public static long measureTreeSetSearch(TreeSet<Integer> set, int target) {
        long start = System.nanoTime();
        treeSetSearch(set, target);
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 100000, 1000000};

        System.out.printf("%-15s %-20s %-20s %-20s%n",
                "Dataset Size", "Array(ns)", "HashSet(ns)", "TreeSet(ns)");

        for (int size : sizes) {

            int[] array = generateArray(size);
            HashSet<Integer> hashSet = buildHashSet(array);
            TreeSet<Integer> treeSet = buildTreeSet(array);

            int target = size - 1; // Worst case for linear search

            long arrayTime = measureArraySearch(array, target);
            long hashSetTime = measureHashSetSearch(hashSet, target);
            long treeSetTime = measureTreeSetSearch(treeSet, target);

            System.out.printf("%-15d %-20d %-20d %-20d%n",
                    size, arrayTime, hashSetTime, treeSetTime);
        }
    }
}
