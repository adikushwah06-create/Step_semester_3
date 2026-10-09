package main.java.OOPFundamental.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class preventing direct instantiation of generic staff
abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method forcing subclasses to define pay calculation
    public abstract double calculatePay();
}

// Full-time staff: fixed weekly salary
class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

// Hourly staff: rate for first 40 hrs + 1.5x rate for overtime[cite: 1]
class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
    }
}

// Intern: fixed stipend[cite: 1]
class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class Payroll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            ;
        }

        int n = scanner.nextInt();
        List<Staff> staffList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            switch (type) {
                case "FULLTIME":
                    double salary = scanner.nextDouble();
                    staffList.add(new FullTimeStaff(name, salary));
                    break;
                case "HOURLY":
                    double hours = scanner.nextDouble();
                    double rate = scanner.nextDouble();
                    staffList.add(new HourlyStaff(name, hours, rate));
                    break;
                case "INTERN":
                    double stipend = scanner.nextDouble();
                    staffList.add(new InternStaff(name, stipend));
                    break;
            }
        }

        double totalPayroll = 0.0;

        // Print each person's pay formatted to 2 decimal places[cite: 1]
        for (Staff member : staffList) {
            double pay = member.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f%n", member.getName(), pay);
        }

        // Print final total payroll[cite: 1]
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);

        scanner.close();
    }
}