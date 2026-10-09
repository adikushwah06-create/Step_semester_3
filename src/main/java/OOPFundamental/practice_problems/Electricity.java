package main.java.OOPFundamental.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a generic electricity connection
abstract class ElectricityConnection {
    protected String type;
    protected int units;

    public ElectricityConnection(String type, int units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    // Abstract method enforced for each connection type
    public abstract double calculateBill();
}

// Home: 5 per unit for first 100 units, 7 per unit after that
class HomeConnection extends ElectricityConnection {
    public HomeConnection(int units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

// Shop: 8 per unit plus a fixed charge of 100
class ShopConnection extends ElectricityConnection {
    public ShopConnection(int units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

// Factory: 6 per unit, with a minimum bill of 1000[cite: 5]
class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(int units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class Electricity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            ;
        }

        int n = scanner.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();

            switch (type) {
                case "HOME":
                    connections.add(new HomeConnection(units));
                    break;
                case "SHOP":
                    connections.add(new ShopConnection(units));
                    break;
                case "FACTORY":
                    connections.add(new FactoryConnection(units));
                    break;
            }
        }

        double totalBill = 0.0;

        // Print each connection bill formatted to two decimal places[cite: 5]
        for (ElectricityConnection conn : connections) {
            double bill = conn.calculateBill();
            totalBill += bill;
            System.out.printf("%s: %.2f%n", conn.getType(), bill);
        }

        // Print total bill formatted to two decimal places[cite: 5]
        System.out.printf("Total: %.2f%n", totalBill);

        scanner.close();
    }
}