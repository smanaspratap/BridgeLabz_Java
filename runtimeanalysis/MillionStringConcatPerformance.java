package runtimeanalysis;
/*
 * MillionStringConcatPerformance analyzes the time taken
 * by String, StringBuilder, and StringBuffer while performing
 * large-scale concatenation operations.
 * It highlights why mutable strings are preferred for heavy modifications.
 */

public class MillionStringConcatPerformance {

    // Demonstrates inefficient concatenation due to immutable String objects
    public static long testStringConcat(int count) {
        long start = System.nanoTime();

        String result = "";
        for (int i = 0; i < count; i++) {
            result += "a"; // Creates a new object every iteration
        }

        return System.nanoTime() - start;
    }

    // Uses mutable object to avoid repeated allocations
    public static long testStringBuilderConcat(int count) {
        long start = System.nanoTime();

        StringBuilder sb = new StringBuilder(count); // Pre-sizing reduces resizing overhead
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }

        return System.nanoTime() - start;
    }

    // Thread-safe version with synchronized methods
    public static long testStringBufferConcat(int count) {
        long start = System.nanoTime();

        StringBuffer sb = new StringBuffer(count); // Slightly slower due to synchronization
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }

        return System.nanoTime() - start;
    }

    public static void main(String[] args) {

        int[] operations = {1000, 10000, 100000}; // Avoid extremely long runtime for String

        System.out.printf("%-20s %-20s %-20s %-20s%n",
                "Operations", "String", "StringBuilder", "StringBuffer");

        for (int count : operations) {

            long stringTime = testStringConcat(count);
            long builderTime = testStringBuilderConcat(count);
            long bufferTime = testStringBufferConcat(count);

            System.out.printf("%-20d %-20d %-20d %-20d%n",
                    count, stringTime, builderTime, bufferTime);
        }
    }
}
