package main.java.programming_Fundamental.practice_problems;

public class ContainsDuplicateFinder {

    /**
     * Checks whether an array contains any duplicate values
     * by comparing every pair of distinct positions using two nested loops.
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        // Outer loop picks each element at position i
        for (int i = 0; i < nums.length; i++) {
            // Inner loop checks every subsequent element at position j
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Duplicate found; return immediately
                }
            }
        }

        // No matching pair found across the entire array
        return false;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums1)); // Output: true

        // Sample Test Case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums2)); // Output: false
    }
}