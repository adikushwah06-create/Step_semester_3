package main.java.string_operations.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StopWordWordFrequencyReport {

    /**
     * Normalizes text, filters out specified stop words, counts frequencies,
     * and prints words sorted by frequency in descending order.
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Fixed list of stop words: "the", "was", "and", "a", "is", "of", "in"
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        // Step 1: Normalize - lowercase and strip punctuation (periods and commas)
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");

        // Step 2: Split text into words using whitespace pattern ("\\s+")
        String[] words = cleaned.trim().split("\\s+");

        // Step 3: Count frequency of non-stop words using a HashMap
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        // Step 4: Sort entries by count in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Step 5: Print each word with its count
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Sample Test Case
        String sampleFeedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(sampleFeedback);
    }
}