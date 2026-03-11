public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("E101", "Amit", "IT");
        Employee cloned = (Employee) original.clone();

        System.out.println("Original: " + original);
        System.out.println("Cloned  : " + cloned);
        System.out.println("Same object? " + (original == cloned));
    }
}

class Employee implements Cloneable {
    private final String id;
    private final String name;
    private final String department;

    public Employee(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow clone is fine for immutable fields
    }

    @Override
    public String toString() {
        return "Employee{id='%s', name='%s', department='%s'}".formatted(id, name, department);
    }
}