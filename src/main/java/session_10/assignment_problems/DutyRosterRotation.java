package main.java.session_10.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class DutyRosterRotation {

    // Function to rotate roster k places to the right
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        if (n == 0) {
            return names;
        }

        // Reduce k to avoid redundant full rotations
        int effectiveK = (int) (k % n);

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            // New position for element at index i after shifting right by k
            int newIndex = (i + effectiveK) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        System.out.println("Enter " + n + " names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        System.out.print("Enter k: ");
        long k = sc.nextLong(); // k can be up to 10^9, so use long

        String[] result = rotateRoster(names, k);

        System.out.println("Rotated Roster: " + Arrays.toString(result));

        sc.close();
    }
}