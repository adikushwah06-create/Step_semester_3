package main.java.OOPFundamental.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class
abstract class Plot {
    protected String owner;
    protected String shape;

    public Plot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }

    public abstract double getArea();

    public void printReport() {
        System.out.printf("%s (%s): %.2f%n", owner, shape, getArea());
    }
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

public class Garden {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) ;
        int n = sc.nextInt();

        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            switch (shape.toUpperCase()) {
                case "CIRCLE":
                    double radius = sc.nextDouble();
                    plots.add(new CirclePlot(owner, radius));
                    break;
                case "RECTANGLE":
                    double length = sc.nextDouble();
                    double width = sc.nextDouble();
                    plots.add(new RectanglePlot(owner, length, width));
                    break;
                case "TRIANGLE":
                    double base = sc.nextDouble();
                    double height = sc.nextDouble();
                    plots.add(new TrianglePlot(owner, base, height));
                    break;
            }
        }

        double totalArea = 0.0;
        for (Plot plot : plots) {
            plot.printReport();
            totalArea += plot.getArea();
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        sc.close();
    }
}