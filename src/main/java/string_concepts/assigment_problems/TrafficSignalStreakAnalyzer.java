package main.java.string_concepts.assigment_problems;

public class TrafficSignalStreakAnalyzer {

    /**
     * Scans a string of signal readings and finds the longest continuous streak
     * of consecutive identical characters.
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Log is empty.");
            return;
        }

        char longestChar = signalLog.charAt(0);
        int maxStreak = 1;

        char currentChar = signalLog.charAt(0);
        int currentStreak = 1;

        // Traverse the string starting from the second character
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentStreak++;
            } else {
                // Streak broke, reset to the new character
                currentChar = signalLog.charAt(i);
                currentStreak = 1;
            }

            // Update max streak if the current one exceeds it
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                longestChar = currentChar;
            }
        }

        // Print output matching the required format
        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestChar, maxStreak);
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        String log1 = "RRGGGYRR";
        findLongestStreak(log1);

        // Sample Test Case 2
        String log2 = "RRRRYYGG";
        findLongestStreak(log2);
    }
}