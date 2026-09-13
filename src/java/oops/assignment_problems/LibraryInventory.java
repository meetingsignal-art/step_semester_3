package oops.assignment_problems;

class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " borrowed successfully.");
        } else {
            System.out.println(title + " is currently unavailable.");
        }
    }

    void returnBook() {
        isAvailable = true;
        System.out.println(title + " returned successfully.");
    }

    void displayStatus() {
        System.out.println(title + " by " + author + " - " + (isAvailable ? "Available" : "Checked Out"));
    }
}

public class LibraryInventory {
    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", "Herbert Schildt");
        b1.borrowBook();
        b1.displayStatus();
        b1.returnBook();
        b1.displayStatus();
    }
}

