package main.java.session_10.practice_problems;



import java.util.Scanner;

public class PrimeNumberChecker {

    // Function to check if a number is prime up to sqrt(n)
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        // Iterate from 2 up to the square root of n (i * i <= n)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false; // Found a factor, not prime
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Processes input lines until no more input is available
        while (sc.hasNextInt()) {
            int num = sc.nextInt();

            if (isPrime(num)) {
                System.out.println(num + " is prime");
            } else {
                System.out.println(num + " is not prime");
            }
        }

        sc.close();
    }
}