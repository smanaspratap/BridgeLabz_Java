/*Program to Display Employee Details
Problem Statement: Write a program to create an Employee class with attributes 
name, id, and salary. Add a method to display the details.
 */

import java.util.Scanner;
class Employee{
    String Name;
    int id;
    int Salary;

    //constructor

    Employee(String Name, int id, int Salary){
        this.Name = Name;
        this.id = id;
        this.Salary = Salary;
    }
    //function to show all the details of the employees

    public void displaydetails(){
        System.out.println("Employee Name: - "+Name+  "\nEmployee id : - "+id+"\nSalary : - "+Salary);
    }

}

public class Employeedata {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String Name;
        int id;
        int Salary;
        System.out.println("Enter your name, id and Salary ");
        Name = in.next();
        id = in.nextInt();
        Salary = in.nextInt();
        Employee emp1 = new Employee(Name, id, Salary);
        emp1.displaydetails();
        in.close();
    }    
}
