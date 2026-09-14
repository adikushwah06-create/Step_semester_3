package main.java.string_concepts.practice_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeCheckerToolkit {

    // Approach 1: Two pointers moving inward from both ends
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive check shrinking the substring from both ends
    public static boolean isPalindromeRecursive(String text) {
        // Base case: empty string or single character is always a palindrome
        if (text.length() <= 1) {
            return true;
        }

        // If outer characters don't match, fail immediately
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        // Recurse on the inner substring
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Convert to char array, reverse a copy, and compare
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return Arrays.equals(original, reversed);
    }

    private static String formatResult(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to check: ");
        String input = scanner.nextLine();

        // Run all three approaches
        boolean resIterative = isPalindromeIterative(input);
        boolean resRecursive = isPalindromeRecursive(input);
        boolean resReversal  = isPalindromeArrayReversal(input);

        // Display results
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                formatResult(resIterative),
                formatResult(resRecursive),
                formatResult(resReversal));

        // Sanity-check validation: ensure all three agreed
        boolean allAgree = (resIterative == resRecursive) && (resRecursive == resReversal);
        if (allAgree) {
            System.out.println("QA Check: PASS (All three methods agreed)");
        } else {
            System.out.println("QA Check: FAIL (Discrepancy detected between methods)");
        }

        scanner.close();
    }
}