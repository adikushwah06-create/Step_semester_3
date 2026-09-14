package main.java.OOP_fundamental.assigment_problems;

public class DuplicatePlayerPickChecker {

    /**
     * Checks a submitted lineup for repeated player names using plain nested loops.
     * Reports the first duplicate found in scanning order.
     * Does not use any Java Collections classes.
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length <= 1) {
            return "No Duplicates Found";
        }

        // Compare each player against subsequent players in the array
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Contains duplicate
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(lineup1)); 
        // Output: Duplicate Found: Kohli

        // Sample Test Case 2: All distinct
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println(findDuplicatePick(lineup2)); 
        // Output: No Duplicates Found
    }
}