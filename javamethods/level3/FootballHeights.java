/*Create a program to find the shortest, tallest, and mean height of players present in a football team.
Hint => 
The formula to calculate the mean is: mean = sum of all elements/number of elements
Create an int array named heights of size 11 and get 3 digits random height in cms for each player in the range 150 cms to 250 cms
Write the method to Find the sum of all the elements present in the array.
Write the method to find the mean height of the players on the football team
Write the method to find the shortest height of the players on the football team 
Write the method to find the tallest height of the players on the football team
Finally display the results
 */
public class FootballHeights {

    // This method calculates the sum of all elements in the array
    public static int sum(int[] arr) {
        int s = 0;

        // Enhanced for-loop to add each height to sum
        for (int x : arr) {
            s += x;
        }

        return s;
    }

    // This method finds and returns the minimum value in the array
    public static int min(int[] arr) {
        int m = arr[0];

        // Compare each element to find the smallest height
        for (int x : arr) {
            if (x < m) {
                m = x;
            }
        }

        return m;
    }

    // This method finds and returns the maximum value in the array
    public static int max(int[] arr) {
        int m = arr[0];

        // Compare each element to find the tallest height
        for (int x : arr) {
            if (x > m) {
                m = x;
            }
        }

        return m;
    }

    public static void main(String[] args) {

        // Create an array to store heights of 11 football players
        int[] heights = new int[11];

        // Generate random heights between 150 cm and 250 cm
        for (int i = 0; i < 11; i++) {
            heights[i] = 150 + (int) (Math.random() * 101);
        }

        // Print all player heights
        System.out.println("Heights:");
        for (int h : heights) {
            System.out.print(h + " ");
        }

        // Calculate and print the mean (average) height
        System.out.println("\nMean: " + (sum(heights) / 11.0));

        // Print the shortest player height
        System.out.println("Shortest: " + min(heights));

        // Print the tallest player height
        System.out.println("Tallest: " + max(heights));
    }
}

