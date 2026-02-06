/*5. Doubly Linked List: Library Management System
Problem Statement: Design a library management system using a doubly linked list. Each node represents a book and contains the following attributes: Book Title, Author, Genre, Book ID, and Availability Status. Implement the following functionalities:
Add a new book at the beginning, end, or at a specific position.
Remove a book by Book ID.
Search for a book by Book Title or Author.
Update a book’s Availability Status.
Display all books in forward and reverse order.
Count the total number of books in the library.
Hint:
Use a doubly linked list with two pointers (next and prev) in each node to facilitate traversal in both directions.
Ensure that when removing a book, both the next and prev pointers are correctly updated.
Displaying in reverse order will require traversal from the last node using prev pointers.
*/
import java.util.LinkedList;
import java.util.ListIterator;

/* ================= BOOK CLASS ================= */
class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;

    Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "ID: " + bookId +
                ", Title: " + title +
                ", Author: " + author +
                ", Genre: " + genre +
                ", Available: " + isAvailable;
    }
}

/* ================= LIBRARY MANAGEMENT ================= */
class LibraryManagement {

    private LinkedList<Book> library;

    public LibraryManagement() {
        library = new LinkedList<>();
    }

    // Add at beginning
    public void addAtBeginning(Book book) {
        library.addFirst(book);
    }

    // Add at end
    public void addAtEnd(Book book) {
        library.addLast(book);
    }

    // Add at specific position (0-based index)
    public void addAtPosition(int index, Book book) {
        if (index < 0 || index > library.size()) {
            System.out.println("Invalid position");
            return;
        }
        library.add(index, book);
    }

    // Remove book by ID
    public void removeByBookId(int bookId) {
        for (Book book : library) {
            if (book.bookId == bookId) {
                library.remove(book);
                System.out.println("Book removed successfully");
                return;
            }
        }
        System.out.println("Book not found");
    }

    // Search by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : library) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with this title");
        }
    }

    // Search by author
    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : library) {
            if (book.author.equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found by this author");
        }
    }

    // Update availability status
    public void updateAvailability(int bookId, boolean status) {
        for (Book book : library) {
            if (book.bookId == bookId) {
                book.isAvailable = status;
                System.out.println("Availability updated");
                return;
            }
        }
        System.out.println("Book not found");
    }

    // Display forward
    public void displayForward() {
        if (library.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }
        for (Book book : library) {
            System.out.println(book);
        }
    }

    // Display reverse
    public void displayReverse() {
        if (library.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }
        ListIterator<Book> iterator = library.listIterator(library.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    // Count total books
    public int totalBooks() {
        return library.size();
    }
}

/* ================= MAIN CLASS ================= */
class lib{
    public static void main(String[] args) {

        LibraryManagement library = new LibraryManagement();

        library.addAtEnd(new Book(101, "Clean Code", "Robert Martin", "Programming", true));
        library.addAtBeginning(new Book(102, "Atomic Habits", "James Clear", "Self Help", true));
        library.addAtPosition(1, new Book(103, "Effective Java", "Joshua Bloch", "Programming", false));

        System.out.println("\n--- Display Forward ---");
        library.displayForward();

        System.out.println("\n--- Display Reverse ---");
        library.displayReverse();

        System.out.println("\n--- Search by Title ---");
        library.searchByTitle("Clean Code");

        System.out.println("\n--- Search by Author ---");
        library.searchByAuthor("Joshua Bloch");

        System.out.println("\n--- Update Availability ---");
        library.updateAvailability(103, true);

        System.out.println("\n--- Remove Book ---");
        library.removeByBookId(101);

        System.out.println("\n--- Final Library ---");
        library.displayForward();

        System.out.println("\nTotal Books: " + library.totalBooks());
    }
}

