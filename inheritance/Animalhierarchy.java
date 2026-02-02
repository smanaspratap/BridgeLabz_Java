/* Animal Hierarchy 
○ Description: Create a hierarchy where Animal is the superclass, and Dog, Cat, 
and Bird are subclasses. Each subclass has a unique behavior. 
○ Tasks: 
■ Define a superclass Animal with attributes name and age, and a method 
makeSound(). 
■ Define subclasses Dog, Cat, and Bird, each with a unique 
implementation of makeSound(). 
○ Goal: Learn basic inheritance, method overriding, and polymorphism with simple 
classes.  */

class Animal{

    //This is how we create a parent class.
    String name;
    int age;
    //Constructor for parent class.
    Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    //Function to make a sound.
    public void makeSound(){
        System.out.println("The Sound that I make is ");
    }
}

class Dog extends Animal{
    //constructor of the dog class
    Dog(String name, int age){
        super(name, age);
    }
    //Polymorphism Method overriding. 
    @Override
    public void makeSound(){
        System.out.println("I Bark!!");
    }

}

class Cat extends Animal{
    //contructor
    Cat(String name, int age){
        super(name,age);
    }

    @Override
    public void makeSound(){
        System.out.println("I meow!!");
    }

}
class Bird extends Animal{
    //constructor
    Bird(String name, int age){
        super(name,age);
    }

    @Override
    public void makeSound(){
        System.out.println("I Chirp!!");
    }
}

public class Animalhierarchy{
    public static void main(String[] args) {
        Animal a; // Intialized the Animal a but what the function does actully depends on the child 
        //class
        //Dog is called hence the function will be called from the dog class.
        a = new Dog("Oreo", 4);
        a.makeSound();
        //Cat is called hence the function will be called from the cat class.
        a = new Cat("Pablo", 5);
        a.makeSound();
        //Bird is called hence the function will be called from the bird class.
        a = new Bird("Mithu", 2);
        a.makeSound();
    }
}