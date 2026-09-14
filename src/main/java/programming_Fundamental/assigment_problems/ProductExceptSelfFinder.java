package main.java.programming_Fundamental.assigment_problems;

import java.util.Arrays;

public class ProductExceptSelfFinder {

    /**
     * Calculates the product of all elements in nums except nums[i]
     * without using the division operator, running in O(n) time and O(1) auxiliary space.
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Forward pass (prefix products)
        // answer[i] will contain the product of all elements to the left of index i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Backward pass (suffix products)
        // Multiply answer[i] by the running product of all elements to the right of index i
        int rightRunningProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightRunningProduct;
            rightRunningProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums1))); // Output: [24, 12, 8, 6]

        // Sample Test Case 2 (with zero)
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums2))); // Output: [0, 0, 9, 0, 0]
    }
}