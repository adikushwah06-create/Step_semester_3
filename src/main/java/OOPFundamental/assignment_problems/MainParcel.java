package main.java.OOPFundamental.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for parcels that can be insured
interface Insurable {
    double calculateInsurance();
}

// Abstract base class representing all parcels
abstract class Parcel {
    protected String type;
    protected double weightKg;
    protected double declaredValue;

    public Parcel(String type, double weightKg, double declaredValue) {
        this.type = type;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public String getType() {
        return type;
    }

    // Every parcel defines how shipping charge is calculated[cite: 9]
    public abstract double calculateShippingCharge();

    // Default insurance is 0.0 unless the parcel implements Insurable
    public double getInsurance() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance();
        }
        return 0.0;
    }

    public double calculateTotal() {
        return calculateShippingCharge() + getInsurance();
    }
}

// Standard parcel: 40 + 10 per kg, cannot be insured[cite: 9, 10]
class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super("STANDARD", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 40.0 + (weightKg * 10.0);
    }
}

// Express parcel: 80 + 15 per kg, 2% insurance on declared value[cite: 10]
class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super("EXPRESS", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 80.0 + (weightKg * 15.0);
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

// Fragile parcel: standard charge + 50 handling fee, 2% insurance[cite: 10]
class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super("FRAGILE", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        // Standard charge is 40 + (weightKg * 10)[cite: 10]
        return 40.0 + (weightKg * 10.0) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class MainParcel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            ;
        }

        int n = scanner.nextInt();
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weightKg = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            switch (type) {
                case "STANDARD":
                    parcels.add(new StandardParcel(weightKg, declaredValue));
                    break;
                case "EXPRESS":
                    parcels.add(new ExpressParcel(weightKg, declaredValue));
                    break;
                case "FRAGILE":
                    parcels.add(new FragileParcel(weightKg, declaredValue));
                    break;
            }
        }

        double grandTotal = 0.0;

        // Print: TYPE: Charge=c Insurance=i Total=t[cite: 9, 10]
        for (Parcel parcel : parcels) {
            double charge = parcel.calculateShippingCharge();
            double insurance = parcel.getInsurance();
            double total = parcel.calculateTotal();
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(), charge, insurance, total);
        }

        // Print Grand Total[cite: 9, 10]
        System.out.printf("Grand Total: %.2f%n", grandTotal);

        scanner.close();
    }
}