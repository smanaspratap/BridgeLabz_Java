/*Circular Linked List: Online Ticket Reservation System
Problem Statement: Design an online ticket reservation system using a circular linked list, where each node represents a booked ticket. Each node will store the following information: Ticket ID, Customer Name, Movie Name, Seat Number, and Booking Time. Implement the following functionalities:
Add a new ticket reservation at the end of the circular list.
Remove a ticket by Ticket ID.
Display the current tickets in the list.
Search for a ticket by Customer Name or Movie Name.
Calculate the total number of booked tickets.

Hint:
Use a circular linked list to represent the ticket reservations, with the last node’s next pointer pointing to the first node.
When removing a ticket, update the circular pointers accordingly.
For displaying all tickets, traverse the list starting from the first node, looping back after reaching the last node.
*/

// Node representing a ticket reservation
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName,
           String movieName, int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    // Add a new ticket at the end
    void bookTicket(int id, String customer,
                    String movie, int seat, String time) {

        Ticket ticket = new Ticket(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = ticket;
            tail.next = head; // Circular link
        } else {
            tail.next = ticket;
            ticket.next = head;
            tail = ticket;
        }
    }

    // Remove ticket by Ticket ID
    void cancelTicket(int ticketId) {
        if (head == null) return;

        Ticket curr = head;
        Ticket prev = tail;

        do {
            if (curr.ticketId == ticketId) {
                if (curr == head)
                    head = head.next;

                if (curr == tail)
                    tail = prev;

                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Display all booked tickets
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println(
                    temp.ticketId + " | " +
                            temp.customerName + " | " +
                            temp.movieName + " | Seat: " +
                            temp.seatNumber);
            temp = temp.next;
        } while (temp != head);
    }

    // Count total tickets
    int totalTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}
