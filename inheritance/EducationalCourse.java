/*Sample Problem 2: Educational Course Hierarchy 
○ Description: Model a course system where Course is the base class, 
OnlineCourse is a subclass, and PaidOnlineCourse extends 
OnlineCourse. 
○ Tasks: 
■ Define a superclass Course with attributes like courseName and 
duration. 
■ Define OnlineCourse to add attributes such as platform and 
isRecorded. 
■ Define PaidOnlineCourse to add fee and discount. 
○ Goal: Demonstrate how each level of inheritance builds on the previous, adding 
complexity to the system. */

// Base class
class Course {
    String courseName;
    int duration; // duration in hours

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// Subclass 1
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
    }
}

// Subclass 2 (multilevel)
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform,
                     boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

// Main class
public class EducationalCourse {
    public static void main(String[] args) {

        PaidOnlineCourse course = new PaidOnlineCourse(
                "Java Full Stack",
                120,
                "Udemy",
                true,
                15,
                20
        );

        course.displayDetails();
    }
}

