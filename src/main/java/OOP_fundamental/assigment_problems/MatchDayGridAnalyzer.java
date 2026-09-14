package main.java.OOP_fundamental.assigment_problems;

public class MatchDayGridAnalyzer {

    /**
     * Private helper to compute the average runs scored in an individual match (row).
     * Handles variable numbers of overs (ragged arrays).
     */
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }

        return sum / row.length;
    }

    /**
     * Classifies each match as "Power Surge" (average >= threshold) or "Normal" (average < threshold).
     * Invokes rowAverage once per match.
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);

            String status = (avg >= threshold) ? "Power Surge" : "Normal";
            sb.append("Match ").append(i).append(": ").append(status);

            // Append separator between matches
            if (i < runsPerOver.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;

        String result = classifyMatches(runsPerOver, threshold);
        System.out.println(result);
        // Output: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}