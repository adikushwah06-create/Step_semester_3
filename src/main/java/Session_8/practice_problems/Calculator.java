package main.java.Session_8.practice_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingDays();

    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getBorrowingDays());
    }

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 3;
    }
}

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) ;

        int n = Integer.parseInt(scanner.nextLine().trim());
        LocalDate baseDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            int firstSpaceIndex = line.indexOf(' ');
            String itemType = line.substring(0, firstSpaceIndex).trim();

            int firstQuote = line.indexOf('\"');
            int lastQuote = line.lastIndexOf('\"');
            String title = (firstQuote != -1 && lastQuote > firstQuote) 
                ? line.substring(firstQuote + 1, lastQuote) 
                : line.substring(firstSpaceIndex + 1).trim();

            LibraryItem item;
            switch (itemType) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title);
                    break;
                default:
                    continue;
            }

            LocalDate dueDate = item.calculateDueDate(baseDate);
            System.out.println(item.getTitle() + ": " + dueDate.format(formatter));
        }

        scanner.close();
    }
}