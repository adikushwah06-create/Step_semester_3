package main.java.OOP_fundamental.assigment_problems;

public class TopPerformerTracker {

    /**
     * Finds the minimum, maximum, and spread (max - min) of scores
     * in a single pass without sorting the array.
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length == 0) {
            return "";
        }

        int min = scores[0];
        int max = scores[0];

        // Single pass to track both minimum and maximum together
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;

        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores)); 
        // Output: Min: 33 | Max: 90 | Spread: 57
    }
}