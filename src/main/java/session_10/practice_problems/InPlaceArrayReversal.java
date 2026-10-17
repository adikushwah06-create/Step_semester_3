package main.java.session_10.practice_problems;



import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {

    // Function to reverse array in-place using two pointers
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Move pointers toward the center, swapping elements along the way
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tokens: ");
        int n = sc.nextInt();

        int[] tokens = new int[n];
        System.out.println("Enter " + n + " token numbers:");
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextInt();
        }

        // Reverse without creating a second array
        reverseArray(tokens);

        // Print the reversed array
        System.out.println("Reversed Output: " + Arrays.toString(tokens));

        sc.close();
    }
}