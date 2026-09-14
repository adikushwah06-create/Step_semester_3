package main.java.string_concepts.assigment_problems;

public class MovieReviewWordLengthProfiler {

    /**
     * Splits a review into words, categorizes each word by length:
     * - Short: 1–4 letters
     * - Medium: 5–8 letters
     * - Long: 9+ letters
     * Prints the aggregated category counts.
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split the string by one or more whitespace characters
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            int len = word.length();

            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        // Print final counts matching the sample output format
        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        // Sample Test Case
        String sampleReview = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(sampleReview);
    }
}