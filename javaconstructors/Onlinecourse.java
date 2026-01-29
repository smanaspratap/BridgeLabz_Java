/*Problem 2: Online Course Management
Design a Course class with:
Instance Variables: courseName, duration, fee.
Class Variable: instituteName (common for all courses).
Methods:
An instance method displayCourseDetails() to display the course details.
A class method updateInstituteName() to modify the institute name for all courses.
 */


class Course {
    String courseName;
    int duration;
    double fee;

    static String instituteName = "ABC Institute";
    //constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
    }

    // Class method
    static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java", 6, 15000);
        Course c2 = new Course("Python", 4, 12000);

        c1.displayCourseDetails();
        System.out.println();

        Course.updateInstituteName("XYZ Academy");

        c2.displayCourseDetails();
    }
}
