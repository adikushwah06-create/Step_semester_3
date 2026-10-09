package main.java.OOPFundamental.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class encapsulating common attributes and the booking fee
abstract class TravelBooking {
    // Booking fee is defined in one place only
    private static final double BOOKING_FEE = 50.0;

    protected String mode;
    protected double distanceKm;

    public TravelBooking(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    public String getMode() {
        return mode;
    }

    // Abstract method for mode-specific base fare calculation
    public abstract double calculateBaseFare();

    // Template method combining base fare and the uniform booking fee[cite: 6]
    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

// Bus: 2 per km[cite: 6]
class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super("BUS", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

// Train: 1.5 per km[cite: 6]
class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

// Flight: 2500 plus 4 per km[cite: 6]
class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
}

public class Travel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            ;
        }

        int n = scanner.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distanceKm = scanner.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings.add(new BusBooking(distanceKm));
                    break;
                case "TRAIN":
                    bookings.add(new TrainBooking(distanceKm));
                    break;
                case "FLIGHT":
                    bookings.add(new FlightBooking(distanceKm));
                    break;
            }
        }

        // Print MODE: total formatted to two decimal places[cite: 6]
        for (TravelBooking booking : bookings) {
            System.out.printf("%s: %.2f%n", booking.getMode(), booking.calculateTotalFare());
        }

        scanner.close();
    }
}