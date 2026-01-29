/*Program to Simulate Student Report
Problem Statement: Create a Student class with attributes name, rollNumber, and marks. 
Add two methods:
To calculate the grade based on the marks.
To display the student's details and grade.
Explanation: The Student class organizes all relevant details about a student as attributes. 
Methods are used to calculate the grade and provide a way to display all information.
 */


class Student {
    // Attributes
    String name;
    int rollNumber;
    int marks;

    // Constructor
    Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade
    char calculateGrade() {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else if (marks >= 60) {
            return 'C';
        } else if (marks >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Method to display student details
    void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Marks       : " + marks);
        System.out.println("Grade       : " + calculateGrade());
    }
}

public class StudentReport {
    public static void main(String[] args) {
        // Creating student object
        Student s1 = new Student("Manas", 101, 88);

        // Display report
        s1.displayDetails();
    }
}
