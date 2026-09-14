package main.java.string_operations.assigment_problems;

public class WordReversalEncoder {

    /**
     * Reverses each word in a sentence individually while maintaining
     * original word order using StringBuilder and loops.
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        // Split sentence into words separated by a single space
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Build reverse of the current word using a loop
            StringBuilder reversedWord = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            // Append reversed word to main result
            result.append(reversedWord);

            // Re-insert space between words
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        String input = "hello club";
        String encoded = reverseEachWord(input);

        System.out.println(encoded);
    }
}