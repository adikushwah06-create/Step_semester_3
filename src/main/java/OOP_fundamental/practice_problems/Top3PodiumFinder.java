package main.java.OOP_fundamental.practice_problems;

import java.util.Arrays;

public class Top3PodiumFinder {

    /**
     * Finds the top 3 highest scores in a single pass without sorting the array.
     * Handles ties and returns the three scores in descending order.
     */
    public static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= first) {
                // Shift lower scores down
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                // Shift second down to third
                third = second;
                second = score;
            } else if (score > third) {
                // Update only third
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        int[] top3 = findTopThreeScores(scores);

        System.out.println(Arrays.toString(top3)); // Output: [90, 90, 82]
    }
}