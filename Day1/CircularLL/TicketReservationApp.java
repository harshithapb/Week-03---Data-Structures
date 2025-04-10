package CircularLL;


import java.util.Scanner;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
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

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        System.out.println("Ticket added successfully.");
    }

    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head, prev = null;
        boolean found = false;

        do {
            if (current.ticketID == ticketID) {
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Ticket not found.");
            return;
        }

        if (head == tail && head.ticketID == ticketID) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            tail.next = head;
        } else if (current == tail) {
            tail = prev;
            tail.next = head;
        } else {
            prev.next = current.next;
        }

        System.out.println("Ticket removed successfully.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        System.out.println("\n--- Booked Tickets ---");
        do {
            System.out.println("Ticket ID: " + temp.ticketID);
            System.out.println("Customer Name: " + temp.customerName);
            System.out.println("Movie Name: " + temp.movieName);
            System.out.println("Seat Number: " + temp.seatNumber);
            System.out.println("Booking Time: " + temp.bookingTime);
            System.out.println("-----------------------------");
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + temp.ticketID);
                System.out.println("Customer Name: " + temp.customerName);
                System.out.println("Movie Name: " + temp.movieName);
                System.out.println("Seat Number: " + temp.seatNumber);
                System.out.println("Booking Time: " + temp.bookingTime);
                System.out.println("-----------------------------");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found with the given name or movie.");
        }
    }

    public void countTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Tickets: " + count);
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("\n--- Ticket Reservation System ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Remove Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket (by Customer/Movie)");
            System.out.println("5. Count Total Tickets");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int removeID = sc.nextInt();
                    sc.nextLine();
                    system.removeTicket(removeID);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer or Movie Name to search: ");
                    String search = sc.nextLine();
                    system.searchTicket(search);
                    break;
                case 5:
                    system.countTickets();
                    break;
                case 0:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}



