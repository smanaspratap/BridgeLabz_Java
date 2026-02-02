/*
Description: Develop a library management system:
Use an abstract class LibraryItem with fields like itemId, title, and author.
Add an abstract method getLoanDuration() and a concrete method getItemDetails().
Create subclasses Book, Magazine, and DVD, overriding getLoanDuration() with specific logic.
Implement an interface Reservable with methods reserveItem() and checkAvailability().
Apply encapsulation to secure details like the borrower’s personal data.
Use polymorphism to allow a general LibraryItem reference to manage all items, regardless of type.
*/

import java.util.ArrayList;
import java.util.List;

/* ---------- Interface ---------- */
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

/* ---------- Abstract Class ---------- */
abstract class LibraryItem {

    private int itemId;
    private String title;
    private String author;

    // sensitive data (encapsulated)
    private String borrowerName;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("ID     : " + itemId);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
    }

    // Encapsulation (setter only for sensitive data)
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
}

/* ---------- Book ---------- */
class Book extends LibraryItem implements Reservable {

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // days
    }

    @Override
    public void reserveItem() {
        System.out.println("Book reserved");
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

/* ---------- Magazine ---------- */
class Magazine extends LibraryItem implements Reservable {

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // days
    }

    @Override
    public void reserveItem() {
        System.out.println("Magazine reserved");
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

/* ---------- DVD ---------- */
class DVD extends LibraryItem implements Reservable {

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // days
    }

    @Override
    public void reserveItem() {
        System.out.println("DVD reserved");
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }
}

/* ---------- Main Class ---------- */
public class LibraryTest {

    public static void main(String[] args) {

        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book(1, "Java Basics", "James Gosling"));
        items.add(new Magazine(2, "Tech Monthly", "Editorial Team"));
        items.add(new DVD(3, "AI Documentary", "OpenAI"));

        // Polymorphism demonstration
        for (LibraryItem item : items) {

            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                System.out.println("Available: " + r.checkAvailability());
            }

            System.out.println("----------------------------");
        }
    }
}
