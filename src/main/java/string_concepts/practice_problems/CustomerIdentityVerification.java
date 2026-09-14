package main.java.string_concepts.practice_problems;

import java.util.Scanner;

public class CustomerIdentityVerification {

    /**
     * Returns a reversed copy of the customer's name without
     * mutating or altering the original string.
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        // Convert the string to a character array for reversal
        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        // In-place two-pointer swap on the local array copy
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        // Construct and return a new string from the reversed characters
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("   CUSTOMER IDENTITY VERIFICATION SYSTEM         ");
        System.out.println("=================================================");
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        // Generate the reversed name
        String reversedName = reverseCustomerName(customerName);

        // Display results to confirm original remains intact
        System.out.println("-------------------------------------------------");
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
        System.out.println("=================================================");

        scanner.close();
    }
}