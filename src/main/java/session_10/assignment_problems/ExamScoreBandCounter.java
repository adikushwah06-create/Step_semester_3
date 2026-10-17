package main.java.session_10.assignment_problems;

import java.util.Scanner;

public class ExamScoreBandCounter {

    // Finds the first index where score >= target (Lower Bound)
    public static int findFirstGE(int[] scores, int target) {
        int left = 0;
        int right = scores.length - 1;
        int ans = scores.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                ans = mid;         // Possible answer, look further left
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // Finds the first index where score > target (Upper Bound)
    public static int findFirstGT(int[] scores, int target) {
        int left = 0;
        int right = scores.length - 1;
        int ans = scores.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                ans = mid;         // Possible answer, look further left
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // Returns the count of scores in [low, high] inclusive
    public static int countInBand(int[] scores, int low, int high) {
        int lowerIndex = findFirstGE(scores, low);   // First position with score >= low
        int upperIndex = findFirstGT(scores, high);  // First position with score > high
        return upperIndex - lowerIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter " + n + " sorted scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Enter low: ");
        int low = sc.nextInt();

        System.out.print("Enter high: ");
        int high = sc.nextInt();

        int result = countInBand(scores, low, high);
        System.out.println("Output: " + result);

        sc.close();
    }
}