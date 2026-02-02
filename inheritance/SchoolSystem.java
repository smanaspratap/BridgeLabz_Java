/*Sample Problem 2: School System with Different Roles 
○ Description: Create a hierarchy for a school system where Person is the 
superclass, and Teacher, Student, and Staff are subclasses. 
○ Tasks: 
■ Define a superclass Person with common attributes like name and age. 
■ Define subclasses Teacher, Student, and Staff with specific 
attributes (e.g., subject for Teacher and grade for Student). 
■ Each subclass should have a method like displayRole() that 
describes the role. 
○ Goal: Demonstrate hierarchical inheritance by modeling different roles in a 
school, each with shared and unique characteristics.  */

// Superclass
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayRole() {
        System.out.println("Person in school");
    }
}

// Teacher subclass
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

// Student subclass
class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

// Staff subclass
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

// Main class
public class SchoolSystem {
    public static void main(String[] args) {

        Person p1 = new Teacher("Mr. Sharma", 40, "Mathematics");
        Person p2 = new Student("Manas", 21, "B.Tech");
        Person p3 = new Staff("Ramesh", 35, "Administration");

        p1.displayRole();
        System.out.println();

        p2.displayRole();
        System.out.println();

        p3.displayRole();
    }
}
