/*ample Problem 1: Restaurant Management System with Hybrid 
Inheritance 
○ Description: Model a restaurant system where Person is the superclass and 
Chef and Waiter are subclasses. Both Chef and Waiter should implement a 
Worker interface that requires a performDuties() method. 
○ Tasks: 
■ Define a superclass Person with attributes like name and id. 
■ Create an interface Worker with a method performDuties(). 
■ Define subclasses Chef and Waiter that inherit from Person and 
implement the Worker interface, each providing a unique implementation 
of performDuties(). 
○ Goal: Practice hybrid inheritance by combining inheritance and interfaces, giving 
multiple behaviors to the same objects.  */

// Interface (multiple behavior)
interface Worker {
    void performDuties();
}

// Superclass
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// Chef subclass
class Chef extends Person implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is cooking food.");
    }
}

// Waiter subclass
class Waiter extends Person implements Worker {

    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " is serving customers.");
    }
}

// Main class
class RestaurantManagement {
    public static void main(String[] args) {

        Worker w1 = new Chef("Rahul", 101);
        Worker w2 = new Waiter("Amit", 102);

        w1.performDuties();
        w2.performDuties();
    }
}
