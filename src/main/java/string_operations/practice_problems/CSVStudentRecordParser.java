package main.java.string_operations.practice_problems;

public class CSVStudentRecordParser {

    /**
     * Parses a CSV line formatted as "Name,RollNumber,Department",
     * validates that exactly 3 fields are present, and displays the formatted record.
     */
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        // Split by comma; passing -1 preserves trailing empty strings if any
        String[] fields = csvLine.split(",", -1);

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        // Check if any field is empty after trimming
        if (name.isEmpty() || rollNumber.isEmpty() || department.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        // Formatted output matching the sample format
        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", name, rollNumber, department);
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Valid input
        String sampleRecord1 = "Ananya Verma,RA2211003010123,CSE";
        parseStudentRecord(sampleRecord1);

        // Sample Test Case 2: Invalid input (missing field)
        String sampleRecord2 = "Ananya Verma,RA2211003010123";
        parseStudentRecord(sampleRecord2);
    }
}