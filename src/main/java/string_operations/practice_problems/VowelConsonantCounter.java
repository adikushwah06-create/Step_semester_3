package main.java.string_operations.practice_problems;

public class VowelConsonantCounter {

    /**
     * Counts vowels and consonants in the given text (case-insensitive)
     * and ignores spaces.
     */
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        // Convert the string to lowercase for case-insensitive checking
        String lower = text.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);

            // Skip spaces
            if (ch == ' ') {
                continue;
            }

            // Check if vowel or consonant (assuming only letters and spaces)
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }

        // Output matching the sample format
        System.out.printf("Vowels: %d | Consonants: %d%n", vowels, consonants);
    }

    public static void main(String[] args) {
        // Sample Test Case
        String input = "Java Programming";
        countVowelsAndConsonants(input);
    }
}