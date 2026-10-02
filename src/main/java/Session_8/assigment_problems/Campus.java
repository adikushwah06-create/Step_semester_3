package main.java.Session_8.assigment_problems;

import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
    public abstract String getVehicleType();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return 10.0 * hours; // ₹10 per hour
    }

    @Override
    public String getVehicleType() {
        return "BIKE";
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        // ₹30 for the first hour, plus ₹20 for each additional hour
        if (hours <= 0) return 0.0;
        return 30.0 + (hours - 1) * 20.0;
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        // ₹50 per hour, minimum charge of ₹100
        double charge = 50.0 * hours;
        return Math.max(charge, 100.0);
    }

    @Override
    public String getVehicleType() {
        return "TRUCK";
    }
}

public class Campus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) ;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();

            Vehicle vehicle;
            switch (type) {
                case "BIKE":
                    vehicle = new Bike(hours);
                    break;
                case "CAR":
                    vehicle = new Car(hours);
                    break;
                case "TRUCK":
                    vehicle = new Truck(hours);
                    break;
                default:
                    continue;
            }

            double charge = vehicle.calculateCharge();
            grandTotal += charge;

            System.out.printf("%s: %.2f\n", vehicle.getVehicleType(), charge);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}