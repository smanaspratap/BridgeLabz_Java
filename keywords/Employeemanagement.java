/*
Sample Program 3: Employee Management System
Demonstrates static, this, final, and instanceof.
*/

class Employee {

    // Static variables
    static String companyName = "Tech Solutions";
    static int totalEmployees = 0;

    // Final variable
    final int id;

    // Instance variables
    String name;
    String designation;

    // Constructor using this
    Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    // Static method
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayEmployeeDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
    }

    public static void main(String[] args) {
        Employee e = new Employee(1, "Manas", "Developer");

        if (e instanceof Employee) {
            e.displayEmployeeDetails();
        }

        Employee.displayTotalEmployees();
    }
}
