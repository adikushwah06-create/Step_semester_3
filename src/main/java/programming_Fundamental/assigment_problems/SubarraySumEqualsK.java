package main.java.programming_Fundamental.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /**
     * Finds the total number of continuous subarrays whose sum equals k
     * using prefix sums and a hash map in O(n) time.
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Map stores: prefixSum -> frequency of occurrence
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        // Base case: a prefix sum of 0 has occurred once (empty prefix)
        prefixSumMap.put(0, 1);

        int runningSum = 0;
        int count = 0;

        for (int num : nums) {
            runningSum += num;

            // Check if there is an earlier prefix sum such that:
            // runningSum - previousPrefixSum = k  =>  previousPrefixSum = runningSum - k
            if (prefixSumMap.containsKey(runningSum - k)) {
                count += prefixSumMap.get(runningSum - k);
            }

            // Record/update the current running prefix sum in the map
            prefixSumMap.put(runningSum, prefixSumMap.getOrDefault(runningSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(subarraySum(nums1, k1)); // Output: 2

        // Sample Test Case 2 (with negative and zero values)
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println(subarraySum(nums2, k2)); // Output: 3
    }
}