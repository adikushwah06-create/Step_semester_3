package main.java.string_concepts.assigment_problems;

public class TypingSpeedAccuracyChecker {

    /**
     * Compares the original and typed strings character-by-character,
     * calculates accuracy percentage, and identifies the first mismatch.
     */
    public static void checkTypingAccuracy(String original, String typed) {
        int totalChars = original.length();
        int matched = 0;
        int firstMismatchIndex = -1;

        for (int i = 0; i < totalChars; i++) {
            char origChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (origChar == typedChar) {
                matched++;
            } else if (firstMismatchIndex == -1) {
                // Record the 1-based position of the very first mistake
                firstMismatchIndex = i + 1;
            }
        }

        double accuracy = ((double) matched / totalChars) * 100.0;

        // Build output string matching sample output format
        if (firstMismatchIndex == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, totalChars, accuracy);
        } else {
            int zeroIndex = firstMismatchIndex - 1;
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, totalChars, accuracy, firstMismatchIndex,
                    original.charAt(zeroIndex), typed.charAt(zeroIndex));
        }
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Mismatch present
        String original1 = "hello world";
        String typed1 = "hello worlt";
        checkTypingAccuracy(original1, typed1);

        // Sample Test Case 2: Perfect match
        String original2 = "coding";
        String typed2 = "coding";
        checkTypingAccuracy(original2, typed2);
    }
}