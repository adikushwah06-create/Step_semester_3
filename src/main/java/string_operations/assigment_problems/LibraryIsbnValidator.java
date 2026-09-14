package main.java.string_operations.assigment_problems;

public class LibraryIsbnValidator {

    /**
     * Normalizes the raw code string:
     * - Trims leading and trailing spaces.
     * - Uppercases only the first 3 characters (publisher code) using substring() + concatenation.
     * - Leaves the remaining characters untouched.
     */
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }

        String trimmed = raw.trim();

        if (trimmed.length() >= 3) {
            return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        }

        return trimmed.toUpperCase();
    }

    /**
     * Validates that the normalized code is exactly 13 characters:
     * - First 3 characters are letters
     * - Remaining 10 characters are digits (using Character.isLetter / Character.isDigit in a loop, no regex)
     * If valid, returns formatted string: "[PUBCODE] YEAR: 20XX | CATALOG: 123456"
     * If invalid, returns the specific error reason.
     */
    public static String validateAndFormat(String code) {
        // Step 1: Check length
        if (code.length() != 13) {
            return "wrong length";
        }

        // Step 2: Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "non-letter publisher code";
            }
        }

        // Step 3: Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "non-digit body";
            }
        }

        // Extract components:
        // Indices 0-2: Publisher Code (3 letters)
        // Indices 3-6: Year (4 digits)
        // Indices 7-12: Catalog Number (6 digits)
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        // Step 4: Build formatted output with StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ")
          .append(year).append(" | CATALOG: ")
          .append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        String rawInput = " pen2026004251 ";
        String normalized = normalizeCode(rawInput);
        String result = validateAndFormat(normalized);

        System.out.println(result);
    }
}