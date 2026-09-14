package main.java.OOP_fundamental.practice_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlacementDriveRankingEngine {

    public static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        /**
         * Computes composite score: (CGPA * 10) + (codingScore * 0.5)
         * - Aisha (8.2, 40) -> 82 + 20 = 102.0
         * - Rohit (6.8, 65) -> 68 + 32.5 = 100.5
         * - Karan (7.5, 20) -> 75 + 10 = 85.0
         */
        public double getCompositeScore() {
            return (this.cgpa * 10.0) + (this.codingScore * 0.5);
        }

        /**
         * Compares candidates in descending order of composite score
         * so Arrays.sort() automatically ranks highest first.
         */
        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    /**
     * Direct CGPA-only filter: CGPA >= 7.5 clears directly.
     */
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    /**
     * Combined borderline filter:
     * Borderline CGPA [6.5, 7.5) requires a strong coding score (>= 60).
     */
    public static boolean isEligible(double cgpa, int codingScore) {
        if (isEligible(cgpa)) {
            return true;
        }
        return cgpa >= 6.5 && codingScore >= 60;
    }

    /**
     * Filters eligible candidates, sorts them using Arrays.sort, and formats output.
     */
    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> qualified = new ArrayList<>();

        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa(), c.getCodingScore())) {
                qualified.add(c);
            }
        }

        // Convert list to array for standard Arrays.sort usage
        Candidate[] shortlisted = qualified.toArray(new Candidate[0]);
        Arrays.sort(shortlisted);

        // Build formatted leaderboard string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            Candidate c = shortlisted[i];
            sb.append(i + 1)
              .append(". ")
              .append(c.getName())
              .append(" (")
              .append(String.format("%.1f", c.getCompositeScore()))
              .append(")");

            if (i < shortlisted.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] batch = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        String result = shortlistAndRank(batch);
        System.out.println(result);
        // Output: 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}