/*Write a program DayOfWeek that takes a date as input and prints the day of the week that the date falls on. Your program should take three command-line arguments: m (month), d (day), and y (year). For m use 1 for January, 2 for February, and so forth. For output print 0 for Sunday, 1 for Monday, 2 for Tuesday, and so forth. Use the following formulas, for the Gregorian calendar (where / denotes integer division):
y0 = y − (14 − m) / 12
x = y0 + y0/4 − y0/100 + y0/400
m0 = m + 12 × ((14 − m) / 12) − 2
d0 = (d + x + 31m0 / 12) mod 7
 */

public class DayOfWeek {

    public static void main(String[] args) {

        // Reading month, day, and year from command-line arguments
        int m = Integer.parseInt(args[0]); // month
        int d = Integer.parseInt(args[1]); // day
        int y = Integer.parseInt(args[2]); // year

        // Adjusting the year based on the month
        // If month is Jan or Feb, it is treated as month 13 or 14 of the previous year
        int y0 = y - (14 - m) / 12;

        // Calculating intermediate value using year adjustments
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;

        // Adjusting the month value for the formula
        int m0 = m + 12 * ((14 - m) / 12) - 2;

        // Calculating the day of the week (0–6)
        // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
        int d0 = (d + x + (31 * m0) / 12) % 7;

        // Printing the day of the week as a number
        System.out.println(d0);
    }
}

