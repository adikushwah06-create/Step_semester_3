package main.java.session_10.practice_problems;


import java.util.Scanner;

public class StudentGradeAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read and process marks until there is no further input
        while (sc.hasNextInt()) {
            int marks = sc.nextInt();

            // Check criteria from highest score downwards
            if (marks >= 90) {
                System.out.println("Grade A");
            } else if (marks >= 75) {
                System.out.println("Grade B");
            } else if (marks >= 60) {
                System.out.println("Grade C");
            } else if (marks >= 40) {
                System.out.println("Grade D");
            } else {
                System.out.println("Grade F");
            }
        }

        sc.close();
    }
}