/*
Sample Program 2: Library Management System
Create a Book class using static, this, final, and instanceof.
*/

class Book {

    // Static variable
    static String libraryName = "Central Library";

    // Final variable
    final String isbn;

    // Instance variables
    String title;
    String author;

    // Constructor using this
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    public static void main(String[] args) {
        Book b = new Book("Java Programming", "Herbert Schildt", "9780135166307");

        // instanceof validation
        if (b instanceof Book) {
            Book.displayLibraryName();
            b.displayBookDetails();
        }
    }
}
