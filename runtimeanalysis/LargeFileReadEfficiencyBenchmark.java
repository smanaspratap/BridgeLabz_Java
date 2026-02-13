package runtimeanalysis;
/*
 * LargeFileReadEfficiencyBenchmark compares FileReader and
 * InputStreamReader performance while reading large files.
 * It helps understand which stream is better suited
 * for high-volume file processing.
 */

import java.io.*;

public class LargeFileReadEfficiencyBenchmark {

    // Reads file character-by-character (less efficient for huge files)
    public static long testFileReader(String filePath) throws IOException {

        long start = System.nanoTime();

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) { // Buffering reduces disk I/O calls

            while (br.read() != -1) {
                // Reading entire file
            }
        }

        return System.nanoTime() - start;
    }

    // Reads bytes and converts them to characters using default charset
    public static long testInputStreamReader(String filePath) throws IOException {

        long start = System.nanoTime();

        try (InputStreamReader isr =
                     new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(isr)) {

            char[] buffer = new char[8192]; // Large buffer improves throughput
            while (br.read(buffer) != -1) {
                // Reading in chunks is faster than single-char reads
            }
        }

        return System.nanoTime() - start;
    }

    public static void main(String[] args) {

        String filePath = "largefile.txt"; // Replace with actual 500MB file path

        try {

            long fileReaderTime = testFileReader(filePath);
            long inputStreamReaderTime = testInputStreamReader(filePath);

            System.out.printf("%-25s %-20s%n", "Method", "Time (ns)");
            System.out.printf("%-25s %-20d%n", "FileReader", fileReaderTime);
            System.out.printf("%-25s %-20d%n", "InputStreamReader", inputStreamReaderTime);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage()); // Important for file handling failures
        }
    }
}
