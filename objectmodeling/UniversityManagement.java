/* Problem 5: University Management System
Description:
Students enroll in Courses.
Professors teach Courses.

Goal:
Use association and aggregation to model interactions.
*/

import java.util.ArrayList;

// Course class
class Course {
    String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }
}

// Student class
class Student {
    String name;
    ArrayList<Course> courses; // Association

    Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    void enrollCourse(Course course) {
        courses.add(course);
        System.out.println(name + " enrolled in " + course.courseName);
    }
}

// Professor class
class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }

    void assignProfessor(Course course) {
        System.out.println(name + " is teaching " + course.courseName);
    }
}

// Main class
public class UniversityManagement {
    public static void main(String[] args) {

        Student s1 = new Student("Manas");
        Professor prof = new Professor("Dr. Sharma");

        Course java = new Course("Java Programming");

        s1.enrollCourse(java);
        prof.assignProfessor(java);
    }
}
