package main.java.Session_8.practice_problems;

import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getTransportType();
}

class Bus extends Transport {
    public Bus(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0); // Maximum fare is capped at $10
    }

    @Override
    public String getTransportType() {
        return "BUS";
    }
}

class Train extends Transport {
    public Train(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }

    @Override
    public String getTransportType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    public String getTransportType() {
        return "METRO";
    }
}

public class Public {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) ;

        int n = Integer.parseInt(scanner.nextLine().trim());
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            Transport transport;
            switch (type) {
                case "BUS":
                    transport = new Bus(distance);
                    break;
                case "TRAIN":
                    transport = new Train(distance);
                    break;
                case "METRO":
                    double peakHourFactor = Double.parseDouble(parts[2]);
                    transport = new Metro(distance, peakHourFactor);
                    break;
                default:
                    continue;
            }

            double fare = transport.calculateFare();
            grandTotal += fare;

            System.out.printf("%s: %.2f\n", transport.getTransportType(), fare);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}