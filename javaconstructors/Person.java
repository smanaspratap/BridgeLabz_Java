/*Create a Person class with a copy constructor that clones another person's attributes.
 */

public class Person {
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Manas", 22);
        Person p2 = new Person(p1);

        p1.display();
        p2.display();
    }
}
