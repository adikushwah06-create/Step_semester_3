package main.java.OOPFundamental.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for students using college bus service
interface BusUser {
    // Transport fee defined in one place only
    double TRANSPORT_FEE = 12000.0;

    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

// Abstract base class representing any student
abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method for base tuition and mandatory student fees[cite: 11, 12]
    public abstract double calculateBaseFee();

    // Total fee combines base fee and transport fee if applicable[cite: 11, 12]
    public double calculateTotalFee() {
        double fee = calculateBaseFee();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).getTransportFee();
        }
        return fee;
    }
}

// Day scholar: tuition 40000 + uses college bus[cite: 11, 12]
class DayScholarStudent extends Student implements BusUser {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 40000.0;
    }
}

// Hosteller: tuition 40000 + hostel fee 60000 (does not use bus)[cite: 11, 12]
class HostellerStudent extends Student {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 40000.0 + 60000.0;
    }
}

// Scholarship student: half tuition (20000) + uses college bus[cite: 11, 12]
class ScholarshipStudent extends Student implements BusUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 20000.0;
    }
}

public class CollegeFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            ;
        }

        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholarStudent(name));
                    break;
                case "HOSTELLER":
                    students.add(new HostellerStudent(name));
                    break;
                case "SCHOLAR":
                    students.add(new ScholarshipStudent(name));
                    break;
            }
        }

        double totalCollected = 0.0;

        // Print: Name: fee formatted to two decimal places
        for (Student student : students) {
            double totalFee = student.calculateTotalFee();
            totalCollected += totalFee;
            System.out.printf("%s: %.2f%n", student.getName(), totalFee);
        }

        // Print final total collected[cite: 11, 12]
        System.out.printf("Total Collected: %.2f%n", totalCollected);

        scanner.close();
    }
}