package main.java.programming_Fundamental.practice_problems;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    /**
     * Merges two already sorted integer arrays into a single sorted array
     * using two pointers and a while loop without re-sorting.
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for result array

        // Compare elements from both arrays and copy the smaller one
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy any remaining elements from arr1
        while (i < n1) {
            result[k++] = arr1[i++];
        }

        // Copy any remaining elements from arr2
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] merged1 = mergeSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(merged1)); // Output: [1, 2, 3, 4, 5, 6]

        // Sample Test Case 2 (with empty array)
        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        int[] merged2 = mergeSortedArrays(arr3, arr4);
        System.out.println(Arrays.toString(merged2)); // Output: [1, 2, 3]
    }
}