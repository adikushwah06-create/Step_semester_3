package main.java.OOPFundamental.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a generic library item
abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    // Abstract method mandating each item type calculates its own fine[cite: 4]
    public abstract double calculateFine();
}

// Book: 2 per day late
class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

// DVD: 5 per day late, capped at a maximum of 50
class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

// Magazine: 1 per day late[cite: 3]
class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            ;
        }

        int n = scanner.nextInt();
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();

            switch (type) {
                case "BOOK":
                    items.add(new Book(title, daysLate));
                    break;
                case "DVD":
                    items.add(new DVD(title, daysLate));
                    break;
                case "MAGAZINE":
                    items.add(new Magazine(title, daysLate));
                    break;
            }
        }

        double totalFines = 0.0;

        // Print fine for each item formatted to two decimal places[cite: 3]
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
        }

        // Print cumulative total fines[cite: 3]
        System.out.printf("Total Fines: %.2f%n", totalFines);

        scanner.close();
    }
}