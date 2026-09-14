package main.java.programming_Fundamental.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumFinder {

    /**
     * Finds all unique triplets in the array that sum up to 0.
     * Sorts the array and applies a two-pointer technique with duplicate avoidance.
     */
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        // Step 1: Sort array to enable two pointers and easily skip duplicates
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Early break: since array is sorted, positive values cannot sum to 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move pointers inward after logging a valid triplet
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Need a larger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] res1 = threeSum(nums1);
        System.out.println(Arrays.deepToString(res1)); // Output: [[-1, -1, 2], [-1, 0, 1]]

        // Sample Test Case 2
        int[] nums2 = {0, 0, 0};
        int[][] res2 = threeSum(nums2);
        System.out.println(Arrays.deepToString(res2)); // Output: [[0, 0, 0]]
    }
}