/*
Use an abstract class Employee with fields like employeeId, name, and baseSalary.
Provide an abstract method calculateSalary() and a concrete method displayDetails().
Create two subclasses: FullTimeEmployee and PartTimeEmployee, implementing calculateSalary() based on work hours or fixed salary.
Use encapsulation to restrict direct access to fields and provide getter and setter methods.
Create an interface Department with methods like assignDepartment() and getDepartmentDetails().
Ensure polymorphism by processing a list of employees and displaying their details using the Employee reference.
 */
package encapsulationandpolymorphism;

import java.util.ArrayList;
import java.util.List;

/* ---------- Interface ---------- */
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

/* ---------- Abstract Class ---------- */
abstract class Employee implements Department {

    // Encapsulated fields
    private int employeeId;
    private String name;
    protected double baseSalary;

    private String department;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Name          : " + name);
        System.out.println("Department    : " + department);
        System.out.println("Final Salary  : " + calculateSalary());
        System.out.println("--------------------------------");
    }

    // Getters & Setters (Encapsulation)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Interface method implementations
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

/* ---------- Full-Time Employee ---------- */
class FullTimeEmployee extends Employee {

    private double bonus;

    public FullTimeEmployee(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}

/* ---------- Part-Time Employee ---------- */
class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

/* ---------- Main Class (Polymorphism Demo) ---------- */
public class EmployeeTest {

    public static void main(String[] args) {

        // Polymorphic list
        List<Employee> employees = new ArrayList<>();

        Employee emp1 = new FullTimeEmployee(101, "Prajwal", 50000, 8000);
        Employee emp2 = new PartTimeEmployee(102, "Amit", 120, 300);

        emp1.assignDepartment("Software Development");
        emp2.assignDepartment("Technical Support");

        employees.add(emp1);
        employees.add(emp2);

        // Polymorphism in action
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
