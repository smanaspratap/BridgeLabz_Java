/*Program to Model a Movie Ticket Booking System
Problem Statement: Create a MovieTicket class with attributes movieName, seatNumber, and price. Add methods to:
Book a ticket (assign seat and update price).
Display ticket details.
Explanation: The MovieTicket class organizes ticket information with attributes. The methods handle booking logic and display ticket details.
 */


class MovieTicket {
    // Attributes
    String movieName;
    int seatNumber;
    double price;

    // Constructor
    MovieTicket(String movieName) {
        this.movieName = movieName;
    }

    // Method to book ticket
    void bookTicket(int seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully!");
    }

    // Method to display ticket details
    void displayTicketDetails() {
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat No    : " + seatNumber);
        System.out.println("Price      : ₹" + price);
    }
}

public class MovieBooking {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Inception");

        ticket.bookTicket(12, 250);
        ticket.displayTicketDetails();
    }
}
