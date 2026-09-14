package main.java.OOP_fundamental.practice_problems;

public class DuplicateTeamNameFinder {

    /**
     * Scans the array using plain nested loops to find the first duplicate team name.
     * Does not use any Java Collections classes.
     */
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length <= 1) {
            return "No Duplicates Found";
        }

        // Compare every name against every subsequent name in order
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i] != null && teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Contains duplicate
        String[] teams1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(teams1)); // Output: Duplicate Found: ByteForce

        // Sample Test Case 2: All unique
        String[] teams2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(teams2)); // Output: No Duplicates Found
    }
}