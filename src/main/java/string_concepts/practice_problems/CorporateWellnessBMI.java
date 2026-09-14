package main.java.string_concepts.practice_problems;

import java.util.Random;

public class CorporateWellnessBMI {

    /**
     * Determines the weight status based on standard WHO BMI categories.
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Computes BMI, resolves status, and displays a formatted summary table.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("=================================================================");
        System.out.println("                 CORPORATE WELLNESS REPORT                       ");
        System.out.println("=================================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double height = heights[i];
            double weight = weights[i];

            // Formula: weight / (height * height)
            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.1f | %-8.2f | %-12s%n",
                    (i + 1), height, weight, bmi, status);
        }

        System.out.println("=================================================================");
    }

    public static void main(String[] args) {
        final int teamSize = 10;
        Random random = new Random();

        // Parallel arrays for heights and weights
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        // Realistic live demo ranges:
        // Height: 1.50 m to 1.95 m
        // Weight: 45.0 kg to 105.0 kg
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + (0.45 * random.nextDouble());
            weights[i] = 45.0 + (60.0 * random.nextDouble());
        }

        // Generate and print the wellness report table
        printWellnessReport(heights, weights);
    }
}