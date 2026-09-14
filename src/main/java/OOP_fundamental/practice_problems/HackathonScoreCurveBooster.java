package main.java.OOP_fundamental.practice_problems;


import java.util.Arrays;

public class HackathonScoreCurveBooster {

    /**
     * Modifies the caller's array directly in place by adding the bonus value
     * to each score. Does not return any value.
     */
    public static void curveScores(int[] scores, int bonus) {
        if (scores == null) {
            return;
        }

        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);

        // Print final leaderboard using Arrays.toString()
        System.out.println(Arrays.toString(scores)); // Output: [80, 95, 70]
    }
}