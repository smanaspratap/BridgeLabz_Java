package Annotation;
@Todo(description = "Class level todo example", priority = Todo.Priority.LOW)
public class SampleTasks {

    @Todo(description = "Implement login validation", priority = Todo.Priority.HIGH, author = "Devraj")
    public void validateLogin() {
        // dummy implementation
        System.out.println("validateLogin() executed");
    }

    @Todo(description = "Add JUnit tests later", priority = Todo.Priority.MEDIUM)
    public void addTests() {
        System.out.println("addTests() executed");
    }

    public void normalMethod() {
        System.out.println("normalMethod() executed (no annotation)");
    }
}