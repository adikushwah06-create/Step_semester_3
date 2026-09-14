package main.java.string_operations.practice_problems;

public class FileExtensionValidator {

    /**
     * Validates whether the filename ends with an accepted extension (pdf, docx, zip)
     * regardless of case.
     * Returns "Accepted" or "Rejected — invalid file type".
     */
    public static String validateFileExtension(String filename) {
        if (filename == null) {
            return "Rejected — invalid file type";
        }

        // Find the last '.' in the filename
        int dotIndex = filename.lastIndexOf('.');

        // Ensure '.' exists and is not the very last character
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        // Extract the extension after the dot
        String extension = filename.substring(dotIndex + 1);

        // Case-insensitive comparison against allowed extensions
        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Valid uppercase extension
        String file1 = "Assignment1.PDF";
        System.out.println(validateFileExtension(file1));

        // Sample Test Case 2: Invalid extension
        String file2 = "notes.txt";
        System.out.println(validateFileExtension(file2));
    }
}