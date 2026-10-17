package main.java.session_10.practice_problems;

import java.util.Scanner;

public class DigitSumAndReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int sumOfDigits = 0;
        int reversedNum = 0;

        int temp = num;
        while (temp > 0) {
            // Extract the last digit using modulo 10
            int lastDigit = temp % 10;

            // Add the extracted digit to the running sum
            sumOfDigits += lastDigit;

            // Build the reversed number
            reversedNum = (reversedNum * 10) + lastDigit;

            // Remove the last digit using integer division
            temp /= 10;
        }

        // Expected output format
        System.out.println("Sum of digits: " + sumOfDigits);
        System.out.println("Reverse: " + reversedNum);

        sc.close();
    }
}