package main.java.OOPFundamental.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface representing the capability to provide night service
interface NightServiceable {
    // Marker/capability interface
}

// Abstract base class representing any cab[cite: 13, 14]
abstract class Cab {
    private static final double MINIMUM_FARE = 100.0; //[cite: 13, 14]

    protected String type;
    protected double km;
    protected String time;

    public Cab(String type, double km, String time) {
        this.type = type;
        this.km = km;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

    // Abstract method returning the per-km rate
    public abstract double getRatePerKm();

    // Check whether the trip is valid based on time of day[cite: 13]
    public boolean canFulfillTrip() {
        if ("NIGHT".equalsIgnoreCase(time)) {
            return this instanceof NightServiceable; //[cite: 13, 14]
        }
        return true;
    }

    // Calculates final fare applying minimum fare and night surcharge[cite: 13, 14]
    public double calculateFare() {
        double baseFare = km * getRatePerKm(); //
        double fare = Math.max(baseFare, MINIMUM_FARE); //[cite: 13, 14]

        if ("NIGHT".equalsIgnoreCase(time)) {
            fare += fare * 0.20; // 20% surcharge applied after minimum[cite: 13, 14]
        }

        return fare;
    }
}

// Mini cab: 10 per km, does not support night service[cite: 13]
class MiniCab extends Cab {
    public MiniCab(double km, String time) {
        super("MINI", km, time);
    }

    @Override
    public double getRatePerKm() {
        return 10.0; //[cite: 13]
    }
}

// Sedan cab: 14 per km, supports night service[cite: 13]
class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km, String time) {
        super("SEDAN", km, time);
    }

    @Override
    public double getRatePerKm() {
        return 14.0; //[cite: 13]
    }
}

// SUV cab: 18 per km, supports night service[cite: 13]
class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double km, String time) {
        super("SUV", km, time);
    }

    @Override
    public double getRatePerKm() {
        return 18.0; //[cite: 13]
    }
}

public class CityCab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            ;
        }

        int n = scanner.nextInt();
        List<Cab> trips = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            switch (cabType) {
                case "MINI":
                    trips.add(new MiniCab(km, time));
                    break;
                case "SEDAN":
                    trips.add(new SedanCab(km, time));
                    break;
                case "SUV":
                    trips.add(new SUVCab(km, time));
                    break;
            }
        }

        double total = 0.0;

        for (Cab trip : trips) {
            if (trip.canFulfillTrip()) {
                double fare = trip.calculateFare();
                total += fare;
                System.out.printf("%s: %.2f%n", trip.getType(), fare); //[cite: 13]
            } else {
                System.out.printf("%s: night service not available%n", trip.getType()); //[cite: 13]
            }
        }

        // Print final total of completed trips[cite: 13, 14]
        System.out.printf("Total: %.2f%n", total); //[cite: 13, 14]

        scanner.close();
    }
}