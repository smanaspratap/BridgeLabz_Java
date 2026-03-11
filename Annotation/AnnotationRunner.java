package Annotation;

import java.lang.reflect.Method;

public class AnnotationRunner {
    public static void main(String[] args) {
        Class<SampleTasks> clazz = SampleTasks.class;

        // 1) Read class-level annotation (if present)
        if (clazz.isAnnotationPresent(Todo.class)) {
            Todo todo = clazz.getAnnotation(Todo.class);
            System.out.println("Class Annotation Found:");
            System.out.println("  description: " + todo.description());
            System.out.println("  author: " + todo.author());
            System.out.println("  priority: " + todo.priority());
            System.out.println();
        }

        // 2) Read method-level annotations
        System.out.println("Method Annotations:");
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("- " + method.getName());
                System.out.println("    description: " + todo.description());
                System.out.println("    author: " + todo.author());
                System.out.println("    priority: " + todo.priority());
            } else {
                System.out.println("- " + method.getName() + " (no @Todo)");
            }
        }
    }
}