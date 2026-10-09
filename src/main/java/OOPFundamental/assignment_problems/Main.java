package main.java.OOPFundamental.assignment_problems;


import java.util.*;

abstract class Appliance {
    protected String name;
    protected double power;

    Appliance(String name, double power) {
        this.name = name;
        this.power = power;
    }

    public double calculateUnits(double hours) {
        return (power * hours) / 1000.0;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }

    public abstract boolean supportsSaver();
}

interface SaverMode {
    double SAVER_FACTOR = 0.75;
}

class Fridge extends Appliance {
    Fridge() {
        super("FRIDGE", 150);
    }

    public boolean supportsSaver() {
        return false;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner() {
        super("AC", 1500);
    }

    public boolean supportsSaver() {
        return true;
    }

    @Override
    public double calculateUnits(double hours) {
        return super.calculateUnits(hours) * SAVER_FACTOR;
    }
}

class TV extends Appliance {
    TV() {
        super("TV", 100);
    }

    public boolean supportsSaver() {
        return false;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer() {
        super("WASHER", 500);
    }

    public boolean supportsSaver() {
        return true;
    }

    @Override
    public double calculateUnits(double hours) {
        return super.calculateUnits(hours) * SAVER_FACTOR;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String applianceName = input[0].toUpperCase();
            double hours = Double.parseDouble(input[1]);
            boolean saver = input.length > 2 &&
                            input[2].equalsIgnoreCase("SAVER");

            Appliance appliance;

            switch (applianceName) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;
                case "AC":
                    appliance = new AirConditioner();
                    break;
                case "TV":
                    appliance = new TV();
                    break;
                case "WASHER":
                    appliance = new Washer();
                    break;
                default:
                    continue;
            }

            if (saver && !appliance.supportsSaver()) {
                System.out.println(appliance.name +
                                   ": saver mode not supported");
                continue;
            }

            double units;

            if (saver) {
                units = appliance.calculateUnits(hours);
            } else {
                // Saver-capable appliances use normal units
                // unless SAVER is explicitly requested.
                units = (appliance.power * hours) / 1000.0;
            }

            double cost = appliance.calculateCost(units);
            totalCost += cost;

            System.out.printf(
                Locale.US,
                "%s: Units=%.2f Cost=%.2f%n",
                appliance.name, units, cost
            );
        }

        System.out.printf(
            Locale.US, "Total Cost: %.2f%n", totalCost
        );

        sc.close();
    }
}