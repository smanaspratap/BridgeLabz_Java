/*Program to Compute Area of a Circle
Problem Statement: Write a program to create a Circle class with an attribute radius. Add methods to calculate and display the 
area and circumference of the circle */
import java.util.Scanner;

//Class of circle
class Circle{
    double radius;
    //constructor
    Circle(double radius){
        this.radius = radius;
    }
    //function to find the area
    public void Area(){
        double Area = (Math.PI)*radius*radius;
        System.out.printf("The Area of the Circle is %.2f%n",Area);
    }
    //function to find the circumference
    public void circumference(){
        double circumference = 2*(Math.PI)*radius;
        System.out.printf("The Circumference of the Circle is %.2f%n",circumference);
    }

}


public class AreaofCircle{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double r;
        System.out.println("ENTER THE RADIUS OF THE CIRCLE!! ");
        r = in.nextDouble();
        Circle c1 = new Circle(r);
        c1.Area();
        c1.circumference();
        in.close();
    }
}