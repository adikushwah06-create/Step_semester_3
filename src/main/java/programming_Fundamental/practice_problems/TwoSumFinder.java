package main.java.programming_Fundamental.practice_problems;

import java.util.Arrays;

public class TwoSumFinder {

    /**
     * Finds two indices in nums whose values add up to target
     * using nested loops and array indexing.
     */
    public static int[] twoSum(int[] nums, int target) {
        // Outer loop selects the first element
        for (int i = 0; i < nums.length; i++) {
            // Inner loop checks every subsequent element
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j}; // Return the pair of indices immediately
                }
            }
        }

        // Fallback if no pair is found (based on constraints, one always exists)
        return new int[]{};
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.printf("%s (nums[%d] + nums[%d] = %d + %d = %d)%n",
                Arrays.toString(result1),
                result1[0], result1[1],
                nums1[result1[0]], nums1[result1[1]],
                target1);

        // Sample Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.printf("%s (nums[%d] + nums[%d] = %d + %d = %d)%n",
                Arrays.toString(result2),
                result2[0], result2[1],
                nums2[result2[0]], nums2[result2[1]],
                target2);
    }
}