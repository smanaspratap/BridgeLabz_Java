/*Extend or Create a UnitConvertor utility class similar to the one shown in the notes to do the following.  Please define static methods for all the UnitConvertor class methods. E.g. 
public static double convertFarhenheitToCelsius(double farhenheit) => 
Method to convert Fahrenheit to Celsius and return the value. Use the following code  double farhenheit2celsius = (farhenheit - 32) * 5 / 9;
Method to convert Celsius to Fahrenheit and return the value. Use the following code  double celsius2farhenheit = (celsius * 9 / 5) + 32;
Method to convert pounds to kilograms and return the value. Use the following code  double pounds2kilograms = 0.453592;
Method to convert kilograms to pounds and return the value. Use the following code  double kilograms2pounds = 2.20462; 
Method to convert gallons to liters and return the value. Use following code to convert   double gallons2liters = 3.78541; 
Method to convert liters to gallons and return the value. Use following code to convert  double liters2gallons = 0.264172; 
 */
public class convertFarhenheitToCelsius{
    static double fToC(double f) { return (f - 32) * 5 / 9; }
    static double cToF(double c) { return (c * 9 / 5) + 32; }
    static double poundsToKg(double p) { return p * 0.453592; }
    static double kgToPounds(double k) { return k * 2.20462; }
    static double gallonsToLiters(double g) { return g * 3.78541; }
    static double litersToGallons(double l) { return l * 0.264172; }
}
