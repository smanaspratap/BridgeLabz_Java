/*StringBuffer Problem 2: Compare StringBuffer with StringBuilder for String Concatenation
Problem:
Write a program that compares the performance of StringBuffer and StringBuilder for
concatenating strings. For large datasets (e.g., concatenating 1 million strings),
compare the execution time of both classes.
Approach:
Initialize two StringBuffer and StringBuilder objects.
Perform string concatenation in both objects, appending 1 million strings (e.g., "hello").
Measure the time taken to complete the concatenation using System.nanoTime() for both StringBuffer and StringBuilder.
Output the time taken by both classes for comparison.
*/

class StringBufferVsStringBuilder {

    public static void main(String[] args) {

        int iterations = 1_000_000;
        String text = "hello";

        // -----------------------------
        // Test StringBuilder
        // -----------------------------
        long startBuilder = System.nanoTime();

        StringBuilder sbuilder = new StringBuilder();

        for (int i = 0; i < iterations; i++) {
            sbuilder.append(text);
        }

        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        // -----------------------------
        // Test StringBuffer
        // -----------------------------
        long startBuffer = System.nanoTime();

        StringBuffer sbuffer = new StringBuffer();

        for (int i = 0; i < iterations; i++) {
            sbuffer.append(text);
        }

        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        // -----------------------------
        // Output Results
        // -----------------------------
        System.out.println("StringBuilder Time (nanoseconds): " + timeBuilder);
        System.out.println("StringBuffer Time  (nanoseconds): " + timeBuffer);

        if (timeBuilder < timeBuffer) {
            System.out.println("StringBuilder is faster.");
        } else {
            System.out.println("StringBuffer is faster.");
        }
    }
}
