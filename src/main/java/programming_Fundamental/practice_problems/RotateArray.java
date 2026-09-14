package main.java.programming_Fundamental.practice_problems;

import java.util.Arrays;

public class RotateArray {

    /**
     * Rotates an array of integers to the right by k positions
     * using modulo arithmetic for circular placement.
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;

        // Reduce k to avoid redundant full-cycle rotations
        k = k % n;

        int[] rotated = new int[n];

        // Place each element at its shifted index
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(rotateArray(nums1, k1))); // Output: [5, 6, 7, 1, 2, 3, 4]

        // Sample Test Case 2 (k > length)
        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println(Arrays.toString(rotateArray(nums2, k2))); // Output: [2, 1]
    }
}