package main.java.string_concepts.assigment_problems;

public class WarehouseInventoryBalancer {

    /**
     * Analyzes inventory across two warehouse sections:
     * - Calculates totals for Section A and Section B.
     * - Determines if totals are "Balanced" or "Not Balanced".
     * - Finds the overall highest quantity item, its section, and 1-based item number.
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        int maxQuantity = Integer.MIN_VALUE;
        String maxSection = "";
        int maxItemIndex = -1;

        // Process Section A
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1; // 1-based item position
            }
        }

        // Process Section B
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1; // 1-based item position
            }
        }

        // Determine balance status
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Print final summary matching sample format
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, maxQuantity, maxSection, maxItemIndex);
    }

    public static void main(String[] args) {
        // Sample Test Case
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}