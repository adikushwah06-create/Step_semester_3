package main.java.string_operations.assigment_problems;

public class AtmPinLengthValidator {

    /**
     * Checks if a customer's PIN is exactly 4 digits long.
     * Uses only length() and a single if / else check.
     */
    public static void checkPinLength(String pin) {
        if (pin != null && pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        }
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Invalid length
        String testPin1 = "482";
        checkPinLength(testPin1);

        // Sample Test Case 2: Valid length
        String testPin2 = "4820";
        checkPinLength(testPin2);
    }
}