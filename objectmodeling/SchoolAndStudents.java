/* Self Problem 1: School and Students with Courses (Association and Aggregation)
Description:
A School has multiple Students (Aggregation).
Each Student can enroll in multiple Courses and
each Course can have multiple Students (Association).

Goal:
Practice association by modeling many-to-many relationships
between students and courses.
*/

import java.util.ArrayList;

// Course class (associated with Students)
class Course {
    String courseName;
    ArrayList<Student> enrolledStudents; // Association with Student

    // Constructor
    Course(String courseName) {
        this.courseName = courseName;
        enrolledStudents = new ArrayList<>();
    }

    // Add student to course
    void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    // Display students enrolled in this course
    void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.name);
        }
    }
}

// Student class (aggregated by School, associated with Course)
class Student {
    String name;
    ArrayList<Course> courses; // Association with Course

    // Constructor
    Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    // Enroll student in a course
    void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this); // Linking both sides (many-to-many)
    }

    // View courses enrolled by student
    void viewCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

// School class (aggregates Students)
public class SchoolAndStudents {
    String schoolName;
    ArrayList<Student> students; // Aggregation (School HAS-A Student)

    // Constructor
    SchoolAndStudents(String schoolName) {
        this.schoolName = schoolName;
        students = new ArrayList<>();
    }

    // Add student to school
    void addStudent(Student student) {
        students.add(student);
    }

    public static void main(String[] args) {

        // Creating School
        SchoolAndStudents school = new SchoolAndStudents("Green Valley School");

        // Creating Students (can exist independently)
        Student s1 = new Student("Manas");
        Student s2 = new Student("Rahul");

        // Creating Courses (independent objects)
        Course java = new Course("Java");
        Course python = new Course("Python");

        // Adding students to school (Aggregation)
        school.addStudent(s1);
        school.addStudent(s2);

        // Enrolling students in courses (Association)
        s1.enrollCourse(java);
        s1.enrollCourse(python);
        s2.enrollCourse(java);

        // Viewing enrollments
        s1.viewCourses();
        s2.viewCourses();

        java.showEnrolledStudents();
        python.showEnrolledStudents();
    }
}
