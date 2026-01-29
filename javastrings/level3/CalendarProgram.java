/*
Create a program to display a calendar for a given month and year
*/
import java.util.*;

public class CalendarProgram {

    static boolean leap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int m = s.nextInt();
        int y = s.nextInt();

        String[] mon = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };

        int[] d = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        if (leap(y))
            d[1] = 29;

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (1 + x + 31 * m0 / 12) % 7;

        System.out.println(mon[m - 1] + " " + y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < d0; i++)
            System.out.print("    ");

        for (int i = 1; i <= d[m - 1]; i++) {
            System.out.printf("%3d ", i);

            if ((i + d0) % 7 == 0)
                System.out.println();
        }

        s.close();
    }
}
