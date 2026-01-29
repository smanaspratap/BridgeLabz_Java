/* Self Problem 2: University with Faculties and Departments
(Composition and Aggregation)

Description:
A University has multiple Departments and Faculty members.
- Departments cannot exist without University (Composition).
- Faculty members can exist independently (Aggregation).

Goal:
Understand the difference between composition and aggregation
in complex hierarchical relationships.
*/

import java.util.ArrayList;

// Faculty class (Aggregation: can exist independently)
class Faculty {
    String name;
    String specialization;

    // Constructor
    Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    // Display faculty details
    void displayFaculty() {
        System.out.println("Faculty: " + name + ", Specialization: " + specialization);
    }
}

// Department class (Composition: depends on University)
class Department {
    String deptName;

    // Constructor
    Department(String deptName) {
        this.deptName = deptName;
    }

    // Display department details
    void displayDepartment() {
        System.out.println("Department: " + deptName);
    }
}

// University class
public class UniversitiesFacultiesAndDept {
    String universityName;
    ArrayList<Department> departments; // Composition
    ArrayList<Faculty> faculties;      // Aggregation

    // Constructor
    UniversitiesFacultiesAndDept(String universityName) {
        this.universityName = universityName;
        departments = new ArrayList<>();
        faculties = new ArrayList<>();
    }

    // Add department (created & owned by University)
    void addDepartment(String deptName) {
        departments.add(new Department(deptName)); // Department created internally
    }

    // Add faculty (independent object)
    void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Display university structure
    void displayUniversity() {
        System.out.println("University: " + universityName);

        System.out.println("\nDepartments:");
        for (Department d : departments) {
            d.displayDepartment();
        }

        System.out.println("\nFaculties:");
        for (Faculty f : faculties) {
            f.displayFaculty();
        }
    }

    public static void main(String[] args) {

        // Independent Faculty objects (exist without University)
        Faculty f1 = new Faculty("Dr. Sharma", "Computer Science");
        Faculty f2 = new Faculty("Dr. Mehta", "Mathematics");

        // Creating University
        UniversitiesFacultiesAndDept uni =
                new UniversitiesFacultiesAndDept("National University");

        // Adding Departments (Composition)
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mechanical Engineering");

        // Adding Faculty (Aggregation)
        uni.addFaculty(f1);
        uni.addFaculty(f2);

        // Display university details
        uni.displayUniversity();

        // Deleting university object
        // Departments are destroyed with University (Composition)
        // Faculty objects still exist independently
        uni = null;

        // Faculty still accessible
        System.out.println("\nFaculty objects still exist after University deletion:");
        f1.displayFaculty();
        f2.displayFaculty();
    }
}
