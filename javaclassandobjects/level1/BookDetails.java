/*(Program to Handle Book Details
Problem Statement: Write a program to create a Book class with attributes title, author, and price. Add a method to display the 
book details.
) */

import java.util.Scanner;

class Book{
    String title;
    String author;
    float price;
    //constructor
    Book(String title, String author, float price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void display(){
        System.out.println("The book name is "+title+", written by "+author+". \nThe Price is $"+price);
    }
}


public class BookDetails{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String title;
        String author;
        float price;
        System.out.println("Enter the book title, author and price in $.");
        title = in.nextLine();
        author = in.nextLine();
        price = in.nextFloat();

        Book b1 = new Book(title, author, price);
        b1.display();
        in.close();

    }
}