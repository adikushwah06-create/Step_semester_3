package main.java.programming_Fundamental.assigment_problems;

public class MaximumSubarrayFinder {

    /**
     * Finds the contiguous subarray with the largest sum using Kadane's Algorithm.
     * Operates in O(n) time and O(1) space.
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize with the first element to correctly handle arrays with all negative numbers
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the existing subarray or start fresh from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the overall maximum subarray sum seen so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Mixed positive and negative values
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums1)); // Output: 6 (from [4, -1, 2, 1])

        // Sample Test Case 2: All negative numbers
        int[] nums2 = {-3, -1, -2};
        System.out.println(maxSubArray(nums2)); // Output: -1 (single largest element)
    }
}