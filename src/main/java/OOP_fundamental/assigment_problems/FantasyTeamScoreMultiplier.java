package main.java.OOP_fundamental.assigment_problems;
import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    /**
     * Directly modifies the caller's array in place by applying:
     * - 2.0x multiplier to captain's score
     * - 1.5x multiplier to vice-captain's score
     * Leaves all other scores untouched. Returns nothing.
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }

        // Direct index updates without iterating the entire array
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        // Sample Test Case
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);

        System.out.println(Arrays.toString(scores)); 
        // Output: [40.0, 110.0, 30.0, 93.0]
    }
}