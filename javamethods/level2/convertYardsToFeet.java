/*Extend or Create a UnitConvertor utility class similar to the one shown in the notes to do the following.  Please define static methods for all the UnitConvertor class methods. E.g. 
public static double convertYardsToFeet(double yards) => 
Method to convert yards to feet and return the value. Use following code to convert  double yards2feet = 3;
Method to convert feet to yards and return the value. Use following code to convert  double feet2yards = 0.333333;
Method to convert meters to inches and return the value. Use following code to convert  double meters2inches = 39.3701;
Method to convert inches to meters and return the value. Use following code to convert  double inches2meters = 0.0254;
Method to convert inches to centimeters and return the value. Use the following code  double inches2cm = 2.54;
 */
public class convertYardsToFeet {
    static double yardsToFeet(double y) { return y * 3; }
    static double feetToYards(double f) { return f * 0.333333; }
    static double metersToInches(double m) { return m * 39.3701; }
    static double inchesToMeters(double i) { return i * 0.0254; }
    static double inchesToCm(double i) { return i * 2.54; }
}
