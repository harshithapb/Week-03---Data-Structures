package DoublyLL;

import java.util.Date;
import java.util.Scanner;

public class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
class MovieManager{
    Movie head = null;
    Movie tail = null;
    public void addAtBeginning(Movie newMovie){
        if(head == null){
            head = tail = newMovie;
        }else{
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }
    public void addAtEnd(Movie newMovie){
        if (tail == null){
            head=tail= newMovie;
        }else{
            tail.next = newMovie;
            newMovie.prev=tail;
            tail = newMovie;
        }
    }
    public void addAtPosition(Movie newMovie,int position){
        if(position <=1 || head == null){
            addAtBeginning(newMovie);
            return;
        }
        Movie temp = head;
        for(int i=1;i<position-1 && temp.next != null;i++){
            temp = temp.next;
        }
        if(temp.next == null){
            addAtEnd(newMovie);
        }else{
            newMovie.next = temp.next;
            newMovie.prev = temp;
            temp.next.prev = newMovie;
            temp.next = newMovie;
        }
    }
    public void removeBYTitle(String title){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        Movie temp = head;
        while(temp != null && !temp.title.equalsIgnoreCase(title)){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Movie not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        System.out.println("Movie removed.");
    }

    public void searchByDirectorOrRating(String keyword) {
        boolean found = false;
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(keyword) ||
                    String.valueOf(temp.rating).equals(keyword)) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No match found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        Movie temp = head;
        while (temp != null) {
            printMovie(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        Movie temp = tail;
        while (temp != null) {
            printMovie(temp);
            temp = temp.prev;
        }
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    private void printMovie(Movie m) {
        System.out.println("Title: " + m.title + ", Director: " + m.director + ", Year: " + m.year + ", Rating: " + m.rating);
    }
}

class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManager manager = new MovieManager();

        while (true) {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search by Director or Rating");
            System.out.println("6. Display All (Forward)");
            System.out.println("7. Display All (Reverse)");
            System.out.println("8. Update Rating by Title");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = sc.nextDouble();
                    Movie newMovie = new Movie(title, director, year, rating);

                    if (choice == 1) {
                        manager.addAtBeginning(newMovie);
                    } else if (choice == 2) {
                        manager.addAtEnd(newMovie);
                    } else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        manager.addAtPosition(newMovie, pos);
                    }
                    break;

                case 4:
                    System.out.print("Enter Title to Remove: ");
                    String removeTitle = sc.nextLine();
                    manager.removeBYTitle(removeTitle);
                    break;

                case 5:
                    System.out.print("Enter Director or Rating to Search: ");
                    String keyword = sc.nextLine();
                    manager.searchByDirectorOrRating(keyword);
                    break;

                case 6:
                    manager.displayForward();
                    break;

                case 7:
                    manager.displayReverse();
                    break;

                case 8:
                    System.out.print("Enter Title to Update Rating: ");
                    String updateTitle = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    double newRating = sc.nextDouble();
                    manager.updateRating(updateTitle, newRating);
                    break;

                case 9:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}