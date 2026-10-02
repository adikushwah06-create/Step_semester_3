package main.java.Session_8.assigment_problems;

import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculateBonus();

    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 0.10 * monthlySalary; // 10% of monthly salary
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 0.05 * monthlySalary; // 5% of monthly salary
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.0; // Fixed bonus of ₹2,000
    }
}

public class Festival {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) ;

        int n = scanner.nextInt();
        double totalBonus = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();

            Employee employee;
            switch (type) {
                case "FULLTIME":
                    employee = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    employee = new PartTimeEmployee(name, salary);
                    break;
                case "INTERN":
                    employee = new InternEmployee(name, salary);
                    break;
                default:
                    continue;
            }

            double bonus = employee.calculateBonus();
            totalBonus += bonus;

            System.out.printf("%s: %.2f\n", employee.getName(), bonus);
        }

        System.out.printf("Total Bonus: %.2f\n", totalBonus);
        scanner.close();
    }
}