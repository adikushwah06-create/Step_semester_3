package main.java.Session_8.assigment_problems;

import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getRoomType();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return 8.0 * units; // ₹8 per unit
    }

    @Override
    public String getRoomType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        // ₹6 per unit, divided equally by the number of occupants
        return (6.0 * units) / occupants;
    }

    @Override
    public String getRoomType() {
        return "SHARED";
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        // ₹10 per unit, plus a fixed charge of ₹200
        return (10.0 * units) + 200.0;
    }

    @Override
    public String getRoomType() {
        return "AC";
    }
}

public class Hostel {
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
            int units = Integer.parseInt(parts[1]);

            Room room;
            switch (type) {
                case "SINGLE":
                    room = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = Integer.parseInt(parts[2]);
                    room = new SharedRoom(units, occupants);
                    break;
                case "AC":
                    room = new ACRoom(units);
                    break;
                default:
                    continue;
            }

            double bill = room.calculateBill();
            grandTotal += bill;

            System.out.printf("%s: %.2f\n", room.getRoomType(), bill);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}