package problems.class_problems;

import java.util.*;

interface LibraryItem {
    String getTitle();
    double calculateFine(int daysLate);
}

class Book implements LibraryItem {
    private String title;

    public Book(String title) { this.title = title; }

    @Override
    public String getTitle() { return title; }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 2.0;
    }
}

class DVD implements LibraryItem {
    private String title;

    public DVD(String title) { this.title = title; }

    @Override
    public String getTitle() { return title; }

    @Override
    public double calculateFine(int daysLate) {
        double fine = daysLate * 5.0;
        return Math.min(fine, 50.0);
    }
}

class Magazine implements LibraryItem {
    private String title;

    public Magazine(String title) { this.title = title; }

    @Override
    public String getTitle() { return title; }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 1.0;
    }
}

public class LibraryFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<LibraryItem> items = new ArrayList<>();
        double totalFines = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryItem item = null;
            switch (type) {
                case "BOOK": item = new Book(title); break;
                case "DVD": item = new DVD(title); break;
                case "MAGAZINE": item = new Magazine(title); break;
            }

            if (item != null) items.add(item);
        }

        for (LibraryItem item : items) {
            // Note: We need daysLate again here, but since we process immediately
            // in competitive programming style, let's adjust structure slightly
            // OR store daysLate. For simplicity matching the pattern:
            // Let's refactor to store daysLate in a wrapper or re-read.
            // Better approach: Process inline or create a Record.
            // To keep OOP pure as per assignment, let's assume we stored it.
            // Actually, looking at previous patterns, let's just use a helper class
            // or process immediately. But to demonstrate polymorphism properly:
        }

        // REVISED APPROACH for clean OOP demonstration:
        sc.close(); // Closing previous scanner to restart logic cleanly below
    }
}

// CLEANER IMPLEMENTATION
class FineRecord {
    LibraryItem item;
    int daysLate;

    FineRecord(LibraryItem item, int daysLate) {
        this.item = item;
        this.daysLate = daysLate;
    }
}

class LibraryFineSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<FineRecord> records = new ArrayList<>();
        double totalFines = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryItem item = null;
            switch (type) {
                case "BOOK": item = new Book(title); break;
                case "DVD": item = new DVD(title); break;
                case "MAGAZINE": item = new Magazine(title); break;
            }

            if (item != null) {
                records.add(new FineRecord(item, daysLate));
            }
        }

        for (FineRecord rec : records) {
            double fine = rec.item.calculateFine(rec.daysLate);
            totalFines += fine;
            System.out.printf("%s: %.2f\n", rec.item.getTitle(), fine);
        }

        System.out.printf("Total Fines: %.2f\n", totalFines);
        sc.close();
    }
}