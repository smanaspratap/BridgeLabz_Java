/* Problem 3: Company and Departments (Composition)
Description:
A Company has several Department objects, and each Department
contains Employee objects.

Composition Rule:
Departments and Employees cannot exist without the Company.
If the Company is deleted, all Departments and Employees are also destroyed.

Goal:
Understand composition by implementing a strong HAS-A relationship.
*/

import java.util.ArrayList;

// Employee class (cannot exist without Department)
class Employee {
    String name;
    int id;

    // Constructor to initialize employee
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Display employee details
    void displayEmployee() {
        System.out.println("Employee ID: " + id + ", Name: " + name);
    }
}

// Department class (cannot exist without Company)
class Department {
    String departmentName;
    ArrayList<Employee> employees; // Department COMPOSES Employees

    // Constructor initializes department and employee list
    Department(String departmentName) {
        this.departmentName = departmentName;
        employees = new ArrayList<>();
    }

    // Add employee to department
    void addEmployee(String name, int id) {
        employees.add(new Employee(name, id)); // Employee created inside Department
    }

    // Display department details
    void displayDepartment() {
        System.out.println("Department: " + departmentName);
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }
}

// Company class (owns Departments)
public class CompanyAndDepartments {
    String companyName;
    ArrayList<Department> departments; // Company COMPOSES Departments

    // Constructor initializes company
    CompanyAndDepartments(String companyName) {
        this.companyName = companyName;
        departments = new ArrayList<>();
    }

    // Add department to company
    void addDepartment(Department department) {
        departments.add(department);
    }

    // Display company structure
    void displayCompany() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    public static void main(String[] args) {

        // Creating Company object
        CompanyAndDepartments company = new CompanyAndDepartments("TechCorp");

        // Creating Departments (exist only within Company)
        Department it = new Department("IT");
        Department hr = new Department("HR");

        // Adding employees to departments
        it.addEmployee("Manas", 101);
        it.addEmployee("Rahul", 102);
        hr.addEmployee("Anjali", 201);

        // Adding departments to company
        company.addDepartment(it);
        company.addDepartment(hr);

        // Displaying complete company structure
        company.displayCompany();

        // When company object is deleted,
        // all departments and employees are also eligible for garbage collection
        company = null;
    }
}
