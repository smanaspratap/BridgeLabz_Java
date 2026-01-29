/*
Sample Program 5: University Student Management
Demonstrates static, this, final, and instanceof.
*/

class Student {

    // Static variables
    static String universityName = "ABC University";
    static int totalStudents = 0;

    // Final variable
    final int rollNumber;

    // Instance variables
    String name;
    char grade;

    // Constructor using this
    Student(int rollNumber, String name, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    // Static method
    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void displayStudentDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Student s = new Student(101, "Manas", 'A');

        if (s instanceof Student) {
            s.displayStudentDetails();
        }

        Student.displayTotalStudents();
    }
}
