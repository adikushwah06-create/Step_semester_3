package main.java.OOPFundamental.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class preventing direct instantiation of a plain ticket
abstract class TicketBooking {
    // Single source of truth: convenience fee is 20 per ticket
    private static final double CONVENIENCE_FEE = 20.0;

    protected String seatType;
    protected int count;

    public TicketBooking(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() {
        return seatType;
    }

    // Abstract method for getting seat-specific base price per ticket
    public abstract double getBasePrice();

    // Concrete method calculating total amount including convenience fee
    public double calculateAmount() {
        return count * (getBasePrice() + CONVENIENCE_FEE);
    }
}

// Regular seat: 150 per ticket[cite: 7]
class RegularBooking extends TicketBooking {
    public RegularBooking(int count) {
        super("REGULAR", count);
    }

    @Override
    public double getBasePrice() {
        return 150.0;
    }
}

// Premium seat: 250 per ticket[cite: 7]
class PremiumBooking extends TicketBooking {
    public PremiumBooking(int count) {
        super("PREMIUM", count);
    }

    @Override
    public double getBasePrice() {
        return 250.0;
    }
}

// Recliner seat: 400 per ticket[cite: 7]
class ReclinerBooking extends TicketBooking {
    public ReclinerBooking(int count) {
        super("RECLINER", count);
    }

    @Override
    public double getBasePrice() {
        return 400.0;
    }
}

public class Ticket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            ;
        }

        int n = scanner.nextInt();
        List<TicketBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seatType = scanner.next();
            int count = scanner.nextInt();

            switch (seatType) {
                case "REGULAR":
                    bookings.add(new RegularBooking(count));
                    break;
                case "PREMIUM":
                    bookings.add(new PremiumBooking(count));
                    break;
                case "RECLINER":
                    bookings.add(new ReclinerBooking(count));
                    break;
            }
        }

        double totalCollected = 0.0;

        // Print amount for each booking formatted to two decimal places[cite: 7, 8]
        for (TicketBooking booking : bookings) {
            double amount = booking.calculateAmount();
            totalCollected += amount;
            System.out.printf("%s: %.2f%n", booking.getSeatType(), amount);
        }

        // Print overall total formatted to two decimal places[cite: 7, 8]
        System.out.printf("Total: %.2f%n", totalCollected);

        scanner.close();
    }
}