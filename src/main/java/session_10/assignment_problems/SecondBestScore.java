package main.java.session_10.assignment_problems;

import java.util.Scanner;

public class SecondBestScore {

    // Function to find the second-highest distinct score without sorting
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                // Previous highest becomes the second highest
                second = highest;
                highest = score;
            } else if (score > second && score < highest) {
                // Strictly between second and highest
                second = score;
            }
            // If score == highest or score <= second, skip
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter " + n + " scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int result = secondHighest(scores);
        System.out.println("Expected Output: " + result);

        sc.close();
    }
}