/*Write a program that generates five 4 digit random values and then finds their average value, and their minimum and maximum value. Use Math.random(), Math.min(), and Math.max().
Hint => 
Write a method that generates array of 4 digit random numbers given the size as a parameter as shown in the method signature 
public int[] generate4DigitRandomArray(int size)
Write a method to find average, min and max value of an array 
public double[] findAverageMinMax(int[] numbers)  */
import java.util.*;
public class randomvalues {
    static int[] generate4DigitRandomArray(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) a[i] = (int)(Math.random() * 9000) + 1000;
        return a;
    }
    static double[] findAverageMinMax(int[] a) {
        int min = a[0], max = a[0], sum = 0;
        for (int x : a) {
            sum += x;
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return new double[]{ (double)sum / a.length, min, max };
    }
    public static void main(String[] args) {
        int[] a = generate4DigitRandomArray(5);
        System.out.println(Arrays.toString(a));
        double[] r = findAverageMinMax(a);
        System.out.println("Average = " + r[0]);
        System.out.println("Min = " + r[1]);
        System.out.println("Max = " + r[2]);
    }
}
