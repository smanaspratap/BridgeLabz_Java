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
public class P1_FootballHeights {
    public static int sum(int[] arr){
        int s=0; for(int x:arr) s+=x; return s;
    }
    public static int min(int[] arr){
        int m=arr[0]; for(int x:arr) if(x<m) m=x; return m;
    }
    public static int max(int[] arr){
        int m=arr[0]; for(int x:arr) if(x>m) m=x; return m;
    }
    public static void main(String[] args){
        int[] heights = new int[11];
        for(int i=0;i<11;i++) heights[i]=150+(int)(Math.random()*101);
        System.out.println("Heights:");
        for(int h:heights) System.out.print(h+" ");
        System.out.println("\nMean: "+(sum(heights)/11.0));
        System.out.println("Shortest: "+min(heights));
        System.out.println("Tallest: "+max(heights));
    }
}
