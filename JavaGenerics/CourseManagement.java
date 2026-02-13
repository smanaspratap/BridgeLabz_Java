package JavaGenerics;
/*2. Dynamic Online Marketplace
Concepts: Type Parameters, Generic Methods, Bounded Type Parameters
Problem Statement:
Build a generic product catalog for an online marketplace that supports various product types like Books, Clothing, and Gadgets. Each product type has a specific price range and category.
Hints:
Define a generic class Product<T> where T is restricted to a category (BookCategory, ClothingCategory, etc.).
Implement a generic method to apply discounts dynamically (<T extends Product> void applyDiscount(T product, double percentage)).
Ensure type safety while allowing multiple product categories to exist in the same catalog.
*/
// CourseManagement.java
import java.util.*;

// Base abstract course type
abstract class CourseType {
    private final String evaluationStyle;
    protected CourseType(String evaluationStyle) {
        this.evaluationStyle = evaluationStyle;
    }
    public String getEvaluationStyle() { return evaluationStyle; }
}

class ExamCourse extends CourseType {
    public ExamCourse() { super("Exam-Based"); }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() { super("Assignment-Based"); }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() { super("Research-Based"); }
}

// Generic Course class holding metadata and a CourseType
class Course<T extends CourseType> {
    private final String code;
    private final String title;
    private final T type;

    public Course(String code, String title, T type) {
        this.code = code;
        this.title = title;
        this.type = type;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public T getType() { return type; }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", code, title, type.getEvaluationStyle());
    }
}

// Manager with wildcard method to handle any kind of CourseType
class CourseManager {
    // Accepts any list of Course<?> whose type param extends CourseType
    public static void displayCourseList(List<Course<? extends CourseType>> list) {
        System.out.println("Courses:");
        for (Course<? extends CourseType> c : list) {
            System.out.println(" - " + c);
        }
    }
}

// Demo
public class CourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> cs101 = new Course<>("CS101", "Intro to Programming", new ExamCourse());
        Course<AssignmentCourse> art201 = new Course<>("ART201", "Portfolio Making", new AssignmentCourse());
        Course<ResearchCourse> rs301 = new Course<>("RS301", "Advanced Research Methods", new ResearchCourse());

        List<Course<? extends CourseType>> all = new ArrayList<>();
        all.add(cs101);
        all.add(art201);
        all.add(rs301);

        CourseManager.displayCourseList(all);
    }
}
