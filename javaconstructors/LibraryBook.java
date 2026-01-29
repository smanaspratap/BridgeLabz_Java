/*Library Book System: Create a Book class with attributes title, author, price, and availability. Implement a method to borrow a 
book.
 */

public class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;

    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    void display() {
        System.out.println(title + " by " + author + " | Available: " + available);
    }

    public static void main(String[] args) {
        LibraryBook b = new LibraryBook("OOP in Java", "Herbert Schildt", 650);

        b.display();
        b.borrowBook();
        b.borrowBook();
    }
}

