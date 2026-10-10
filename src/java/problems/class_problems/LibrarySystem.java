package problems.class_problems;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class LibraryItem {
    protected String title;
    protected LocalDate currentDate;

    public LibraryItem(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public abstract int getBorrowingDays();

    public LocalDate calculateDueDate() {
        return currentDate.plusDays(getBorrowingDays());
    }

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title, LocalDate currentDate) {
        super(title, currentDate);
    }

    @Override
    public int getBorrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title, LocalDate currentDate) {
        super(title, currentDate);
    }

    @Override
    public int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, LocalDate currentDate) {
        super(title, currentDate);
    }

    @Override
    public int getBorrowingDays() {
        return 3;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);
            String type = parts[0];
            String title = parts[1].replace("\"", "");

            LibraryItem item;
            switch (type) {
                case "BOOK":
                    item = new Book(title, currentDate);
                    break;
                case "DVD":
                    item = new DVD(title, currentDate);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title, currentDate);
                    break;
                default:
                    continue;
            }

            items.add(item);
        }

        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate();
            System.out.println(item.getTitle() + ": " + dueDate.format(formatter));
        }

        sc.close();
    }
}