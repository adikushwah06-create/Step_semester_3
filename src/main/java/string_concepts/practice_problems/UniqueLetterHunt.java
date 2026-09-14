package main.java.string_concepts.practice_problems;

import java.util.Scanner;

public class UniqueLetterHunt {

    /**
     * Finds the first non-repeating character in a string.
     * Returns the character if found, or null character '\0' if none exists.
     */
    public static char findFirstNonRepeatingChar(String text) {
        // Frequency array covering standard 256 ASCII characters
        int[] freq = new int[256];

        // Pass 1: Count occurrences of every character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Pass 2: Find the first character with a count of exactly 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch; // Early exit on the first unique character
            }
        }

        // Sentinel value indicating no unique character exists
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("     WELCOME TO UNIQUE LETTER HUNT       ");
        System.out.println("=========================================");
        System.out.print("Enter a word or sentence: ");
        String input = scanner.nextLine();

        char result = findFirstNonRepeatingChar(input);

        if (result != '\0') {
            System.out.printf("First Non-Repeating Character: '%c'%n", result);
        } else {
            System.out.println("No Non-Repeating Character Found");
        }

        scanner.close();
    }
}