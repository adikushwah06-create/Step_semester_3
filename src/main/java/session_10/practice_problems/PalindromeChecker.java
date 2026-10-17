package main.java.session_10.practice_problems;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    
            String original = sc.next();

            String reversed = new StringBuilder(original).reverse().toString();

            
            if (original.equals(reversed)) {
                System.out.println(reversed + " - palindrome");
            } else {
                System.out.println(reversed + " - not a palindrome");
            }
        

        sc.close();
    }
}