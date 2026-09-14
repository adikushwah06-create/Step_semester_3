package main.java.string_operations.assigment_problems;

public class ProductInventoryCSVParser {

    /**
     * Parses a CSV inventory record in the form "ProductName,SKU,Quantity",
     * validates that exactly 3 fields are present, and prints the formatted record.
     */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        // Split by comma; -1 preserves trailing empty tokens if present
        String[] fields = csvLine.split(",", -1);

        // Validate that exactly 3 fields exist
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        // Check if any field is empty after trimming
        if (productName.isEmpty() || sku.isEmpty() || quantity.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        // Print formatted output matching the sample format
        System.out.printf("Product: %s | SKU: %s | Qty: %s%n", productName, sku, quantity);
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Valid input
        String validRecord = "Wireless Mouse,WM-2201,150";
        parseInventoryRecord(validRecord);

        // Sample Test Case 2: Invalid input (missing SKU field)
        String invalidRecord = "Wireless Mouse,150";
        parseInventoryRecord(invalidRecord);
    }
}