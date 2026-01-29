/* Problem 1: Library and Books (Aggregation)
Description:
Create a Library class that contains multiple Book objects.
A Library can have many Books, but a Book can exist independently.

Goal:
Understand aggregation by modeling a real-world relationship
where the Library aggregates Book objects.
*/

import java.util.ArrayList;

// Book class (can exist independently of Library)
class Book {
    String title;
    String author;

    // Constructor to initialize book details
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method to display book details
    void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

// Library class (aggregates Book objects)
class Library {
    String libraryName;
    ArrayList<Book> books; // Library HAS-A list of Books (aggregation)

    // Constructor to initialize library
    Library(String libraryName) {
        this.libraryName = libraryName;
        books = new ArrayList<>();
    }

    // Method to add a book to the library
    void addBook(Book book) {
        books.add(book);
    }

    // Method to display all books in the library
    void displayLibraryBooks() {
        System.out.println("Books in " + libraryName + ":");
        for (Book book : books) {
            book.displayBook();
        }
    }
}

// Main class to demonstrate aggregation
public class LibraryManagement {
    public static void main(String[] args) {

        // Creating Book objects independently
        Book b1 = new Book("Java Basics", "James Gosling");
        Book b2 = new Book("Clean Code", "Robert C. Martin");

        // Creating Library objects
        Library lib1 = new Library("City Library");
        Library lib2 = new Library("College Library");

        // Adding books to libraries
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b1); // Same book can exist in another library

        // Displaying library contents
        lib1.displayLibraryBooks();
        lib2.displayLibraryBooks();
    }
}
