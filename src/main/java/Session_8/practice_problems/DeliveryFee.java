package main.java.Session_8.practice_problems;

import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
    public abstract String getDeliveryType();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    public String getDeliveryType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    public String getDeliveryType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    public String getDeliveryType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFee {
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
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);

            Delivery delivery;
            switch (type) {
                case "STANDARD":
                    delivery = new StandardDelivery(weight, distance);
                    break;
                case "EXPRESS":
                    delivery = new ExpressDelivery(weight, distance);
                    break;
                case "INTERNATIONAL":
                    double customsFee = Double.parseDouble(parts[3]);
                    delivery = new InternationalDelivery(weight, distance, customsFee);
                    break;
                default:
                    continue;
            }

            double fee = delivery.calculateFee();
            grandTotal += fee;

            System.out.printf("%s: %.2f\n", delivery.getDeliveryType(), fee);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}