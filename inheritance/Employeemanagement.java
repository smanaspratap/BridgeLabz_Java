/*(Employee Management System 
○ Description: Create an Employee hierarchy for different employee types such 
as Manager, Developer, and Intern. 
○ Tasks: 
■ Define a base class Employee with attributes like name, id, and 
salary, and a method displayDetails(). 
■ Define subclasses Manager, Developer, and Intern with unique 
attributes for each, like teamSize for Manager and 
programmingLanguage for Developer. 
○ Goal: Practice inheritance by creating subclasses with specific attributes and 
overriding superclass methods.) */

class Employee{
    //Employee calss
    String name;
    int id;
    double salary;
    //constructor
    Employee(String name,int id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }   
    //method
    public void displaydetails(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

}
class Manager extends Employee{
    //Manager has its own instance variable
    int teamSize;
    Manager(String name, int id, double salary, int teamSize){
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    @Override
    public void displaydetails(){
        super.displaydetails();
        System.out.println("Team Size: "+teamSize );
    }
}

class Developer extends Employee{
    //Devloper class as a child...
    String programminglanguage;
    Developer(String name, int id, double salary, String programminglanguage){
        super(name, id, salary);
        this.programminglanguage = programminglanguage;
    }
    @Override
    //Method for the developer...
    public void displaydetails(){
        super.displaydetails();
        System.out.println("programminglanguage: "+programminglanguage );
    }
}
class Intern extends Employee{
    int duration; // internship duration in months

    Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    public void displaydetails() {
        super.displaydetails();
        System.out.println("Internship Duration: " + duration + " months");
    }
}

public class Employeemanagement {
   public static void main(String[] args) {
        Employee e1 = new Manager("Manas Pratap Singh", 97, 1500000000,5);
        Developer e2 = new Developer("Om Bandy", 57, 150000, "C++");
        Employee e3 = new Intern("Rahul", 68, 1500, 4);
        //Result doesn't depend on Employee it depends on the child class that is being called.
        e1.displaydetails();
        e2.displaydetails();
        e3.displaydetails();
   } 
}
