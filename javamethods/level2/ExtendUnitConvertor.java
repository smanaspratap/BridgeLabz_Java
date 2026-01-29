/*Extend or Create a UnitConvertor utility class similar to the one shown in the notes to do the following.  Please define static methods for all the UnitConvertor class methods. E.g. 
public static double convertKmToMiles(double km) => 
Method To convert kilometers to miles and return the value. Use the following code  double km2miles = 0.621371;
Method to convert miles to kilometers and return the value. Use the following code  double miles2km = 1.60934;
Method to convert meters to feet and return the value. Use the following code to convert  double meters2feet = 3.28084;
Method to convert feet to meters and return the value. Use the following code to convert  double feet2meters = 0.3048;
 */
public class ExtendUnitConvertor {
    static double kmToMiles(double km) { return km * 0.621371; }
    static double milesToKm(double m) { return m * 1.60934; }
    static double metersToFeet(double m) { return m * 3.28084; }
    static double feetToMeters(double f) { return f * 0.3048; }
}
