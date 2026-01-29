/*Create a program to display a calendar for a given month and year. The program should take the month and year as input from the user and display the calendar for that month. E.g. for 07 2005 user input, the program should display the calendar as shown below
 */
import java.util.*;
public class P8_Calendar {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter month and year: ");
        int m=sc.nextInt(), y=sc.nextInt();
        Calendar c=Calendar.getInstance();
        c.set(y,m-1,1);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int d=c.get(Calendar.DAY_OF_WEEK)-1;
        for(int i=0;i<d;i++) System.out.print("    ");
        int days=c.getActualMaximum(Calendar.DAY_OF_MONTH);
        for(int i=1;i<=days;i++){
            System.out.printf("%3d ",i);
            if((i+d)%7==0) System.out.println();
        }
        sc.close();
    }
}
