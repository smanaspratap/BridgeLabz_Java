package JavaGenerics;
/*3. Multi-Level University Course Management System
Concepts: Generic Classes, Wildcards, Bounded Type Parameters
Problem Statement:
Develop a university course management system where different departments offer courses with different evaluation types (e.g., Exam-Based, Assignment-Based, Research-Based).
Hints:
Create an abstract class CourseType (e.g., ExamCourse, AssignmentCourse, ResearchCourse).
Implement a generic class Course<T extends CourseType> to manage different courses.
Use wildcards (List<? extends CourseType>) to handle any type of course dynamically.
*/
// MealPlanGenerator.java
import java.util.*;

// Meal plan interface and concrete implementations
interface MealPlan {
    boolean meetsConstraints(Map<String, Object> userPrefs);
    String description();
}

class VegetarianMeal implements MealPlan {
    public boolean meetsConstraints(Map<String, Object> userPrefs) {
        // simple example: check a "noMeat" preference
        Object noMeat = userPrefs.get("noMeat");
        return noMeat == null || Boolean.TRUE.equals(noMeat);
    }
    public String description() { return "Vegetarian Meals (no meat)"; }
}

class VeganMeal implements MealPlan {
    public boolean meetsConstraints(Map<String, Object> userPrefs) {
        Object vegan = userPrefs.get("vegan");
        return vegan == null || Boolean.TRUE.equals(vegan);
    }
    public String description() { return "Vegan Meals (no animal products)"; }
}

class KetoMeal implements MealPlan {
    public boolean meetsConstraints(Map<String, Object> userPrefs) {
        // This is a simplifed placeholder check.
        return true;
    }
    public String description() { return "Keto Meal Plan (low-carb, high-fat)"; }
}

// Generic Meal class
class Meal<T extends MealPlan> {
    private final T plan;

    public Meal(T plan) {
        this.plan = plan;
    }

    public T getPlan() { return plan; }

    // Generic method to validate a meal plan against user preferences
    public static <T extends MealPlan> boolean validatePlan(T plan, Map<String, Object> userPreferences) {
        return plan.meetsConstraints(userPreferences);
    }

    // Factory/generator that returns an Optional if plan meets constraints
    public static <T extends MealPlan> Optional<Meal<T>> generatePlan(T plan, Map<String, Object> userPreferences) {
        if (validatePlan(plan, userPreferences)) {
            return Optional.of(new Meal<>(plan));
        } else {
            return Optional.empty();
        }
    }
}

// Demo
public class MealPlanGenerator {
    public static void main(String[] args) {
        Map<String, Object> userPrefs = new HashMap<>();
        userPrefs.put("noMeat", true);
        userPrefs.put("vegan", false);

        VegetarianMeal veg = new VegetarianMeal();
        Optional<Meal<VegetarianMeal>> opt = Meal.generatePlan(veg, userPrefs);

        if (opt.isPresent()) {
            System.out.println("Generated meal plan: " + opt.get().getPlan().description());
        } else {
            System.out.println("No suitable meal plan could be generated.");
        }
    }
}

