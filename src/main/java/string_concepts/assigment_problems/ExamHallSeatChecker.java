package main.java.string_concepts.assigment_problems;



public class ExamHallSeatChecker {

    /**
     * Checks an array of seat numbers for duplicates using nested loops only.
     * (No Collections framework classes used).
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        // Compare every element with every subsequent element
        for (int i = 0; i < seatNumbers.length; i++) {
            // Avoid reporting the same duplicate multiple times if already checked
            boolean alreadyReported = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyReported = true;
                    break;
                }
            }
            if (alreadyReported) {
                continue;
            }

            // Look forward to find if seatNumbers[i] appears again
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break; // Move to the next unique seat to avoid repeated prints for this value
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        // Test Case 1 (Duplicate present)
        int[] hallA = {101, 102, 103, 102, 105};
        System.out.println("Testing Hall A:");
        checkDuplicateSeats(hallA);

        System.out.println();

        // Test Case 2 (No duplicates)
        int[] hallB = {101, 102, 103, 104, 105};
        System.out.println("Testing Hall B:");
        checkDuplicateSeats(hallB);
    }
}