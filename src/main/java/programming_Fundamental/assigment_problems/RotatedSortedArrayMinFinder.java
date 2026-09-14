package main.java.programming_Fundamental.assigment_problems;

public class RotatedSortedArrayMinFinder {

    /**
     * Finds the minimum element in a rotated sorted array of unique integers
     * using modified binary search in O(log n) time.
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the rightmost element,
            // the pivot (minimum element) must be in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the minimum is at mid or in the left half.
                right = mid;
            }
        }

        // When left == right, it points to the smallest element.
        return nums[left];
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums1)); // Output: 1

        // Sample Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums2)); // Output: 0

        // Sample Test Case 3 (Not rotated)
        int[] nums3 = {11, 13, 15, 17};
        System.out.println(findMin(nums3)); // Output: 11
    }
}