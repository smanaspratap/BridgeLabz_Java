/*Problem 2: Book Library System
Design a Book class with:
ISBN (public).
title (protected).
author (private).
Write methods to:
Set and get the author name.
Create a subclass EBook to access ISBN and title and demonstrate access modifiers.
 */

class Book {
    public String ISBN;
    protected String title;
    private String author;

    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Getter & Setter for private variable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

// Subclass
class EBook extends Book {

    EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    void display() {
        System.out.println("ISBN: " + ISBN);     // public
        System.out.println("Title: " + title);   // protected
        System.out.println("Author: " + getAuthor());
    }

    public static void main(String[] args) {
        EBook e = new EBook("978-0135166307", "Java Programming", "Herbert Schildt");
        e.display();
    }
}
