import java.lang.annotation.*;

/**
 * Custom annotation example.
 * - @Target: can be used on methods and types (classes)
 * - @Retention: available at runtime for reflection
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Todo {
    String author() default "Devraj";
    String description();
    Priority priority() default Priority.MEDIUM;

    enum Priority { LOW, MEDIUM, HIGH }
}