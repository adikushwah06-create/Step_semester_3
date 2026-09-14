package main.java.string_concepts.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsArcade {

    private static final String[] CHOICES = {"Rock", "Paper", "Scissors"};

    // Class to store round data for the summary table
    static class RoundRecord {
        int roundNumber;
        String playerMove;
        String computerMove;
        String result;

        RoundRecord(int roundNumber, String playerMove, String computerMove, String result) {
            this.roundNumber = roundNumber;
            this.playerMove = playerMove;
            this.computerMove = computerMove;
            this.result = result;
        }
    }

    /**
     * Evaluates the outcome based on standard Rock-Paper-Scissors rules.
     * Returns "Player Wins", "Computer Wins", or "Draw".
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equalsIgnoreCase("Scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equalsIgnoreCase("Rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equalsIgnoreCase("Paper") ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Move";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int totalRounds = 5;
        List<RoundRecord> records = new ArrayList<>();

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("============================================");
        System.out.println("  WELCOME TO THE COLLEGE CODING ARCADE");
        System.out.println("  Rock-Paper-Scissors Orientation Warm-up   ");
        System.out.println("============================================");

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("\n--- Round " + round + " of " + totalRounds + " ---");
            
            // Validate player input
            String playerMove = "";
            while (true) {
                System.out.print("Enter your move (Rock, Paper, Scissors): ");
                playerMove = scanner.nextLine().trim();
                
                if (playerMove.equalsIgnoreCase("Rock") || 
                    playerMove.equalsIgnoreCase("Paper") || 
                    playerMove.equalsIgnoreCase("Scissors")) {
                    // Standardize casing
                    playerMove = playerMove.substring(0, 1).toUpperCase() + 
                                 playerMove.substring(1).toLowerCase();
                    break;
                }
                System.out.println("Invalid entry. Please choose Rock, Paper, or Scissors.");
            }

            // Generate computer move
            String computerMove = CHOICES[random.nextInt(CHOICES.length)];

            // Determine outcome
            String result = playRound(playerMove, computerMove);

            // Tally score
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            // Save record and show immediate feedback
            records.add(new RoundRecord(round, playerMove, computerMove, result));
            System.out.println("Computer chose: " + computerMove);
            System.out.println("Outcome: " + result);
        }

        // Print final summary table
        System.out.println("\n==========================================================");
        System.out.println("                     MATCH SUMMARY                        ");
        System.out.println("==========================================================");
        System.out.printf("%-8s | %-12s | %-14s | %-13s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("----------------------------------------------------------");

        for (RoundRecord record : records) {
            System.out.printf("%-8d | %-12s | %-14s | %-13s%n",
                    record.roundNumber,
                    record.playerMove,
                    record.computerMove,
                    record.result);
        }

        System.out.println("----------------------------------------------------------");

        // Calculate win percentage
        double winPercentage = ((double) wins / totalRounds) * 100.0;

        // Print statistics
        System.out.printf("Final Scoreboard: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
        System.out.println("==========================================================");

        scanner.close();
    }
}