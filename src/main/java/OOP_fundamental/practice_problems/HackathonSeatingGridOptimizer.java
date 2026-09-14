package main.java.OOP_fundamental.practice_problems;

public class HackathonSeatingGridOptimizer {

    /**
     * Reusable private helper to calculate the average score of a single row.
     * Safely handles jagged rows and empty arrays.
     */
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int score : row) {
            sum += score;
        }

        return sum / row.length;
    }

    /**
     * Classifies each row as "Quiet Zone" (below threshold) or "Buzzing Zone" (at/above threshold).
     * Invokes rowAverage once per row and formats the result.
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);

            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";
            sb.append("Row ").append(i).append(": ").append(zone);

            // Add delimiter between rows
            if (i < seatingScores.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;

        String result = classifyRows(seatingScores, threshold);
        System.out.println(result);
        // Output: Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone
    }
}