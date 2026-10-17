package main.java.session_10.practice_problems;



import java.util.Scanner;

public class FactorialCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Process inputs until no more integers are left
        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            // Using long to avoid integer overflow for larger values
            long factorial = 1;

            // Multiplies from 1 up to n; if n is 0, the loop does not run and leaves factorial as 1
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }

            System.out.println(factorial);
        }

        sc.close();
    }
}