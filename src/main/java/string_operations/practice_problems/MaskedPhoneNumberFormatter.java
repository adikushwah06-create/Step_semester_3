package main.java.string_operations.practice_problems;

public class MaskedPhoneNumberFormatter {

    /**
     * Validates that the phone number is exactly 10 digits and masks
     * the first 6 digits with "XXXXXX-" using StringBuilder.
     */
    public static String maskPhoneNumber(String phone) {
        // Validate null or incorrect length
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validate that every character is a digit
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Build the masked format using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX-");
        sb.append(phone.substring(6)); // Extracts the last 4 digits (indices 6 to 9)

        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Valid 10-digit number
        String phone1 = "9876543210";
        System.out.println(maskPhoneNumber(phone1));

        // Sample Test Case 2: Invalid number (less than 10 digits)
        String phone2 = "98765";
        System.out.println(maskPhoneNumber(phone2));
    }
}