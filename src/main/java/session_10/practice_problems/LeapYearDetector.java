package main.java.session_10.practice_problems;


import java.util.Scanner;

public class LeapYearDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read and process years until input ends
        while (sc.hasNextInt()) {
            int year = sc.nextInt();

            // Divisible by 400 OR (divisible by 4 and not divisible by 100)
            if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
                System.out.println("Leap year");
            } else {
                System.out.println("Not a leap year");
            }
        }

        sc.close();
    }
}