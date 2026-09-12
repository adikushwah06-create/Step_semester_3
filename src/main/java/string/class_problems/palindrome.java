package main.java.string.class_problems;
import java.util.Scanner;

public class palindrome {
    public static void main(String[] args){
     Scanner sc= new Scanner(System.in);

     System.out.println("Enter number: ");
     int num = sc.nextInt();

     int origNumber= num; 
     int reversedNumber =0 ;

     System.out.println("Is the number " + origNumber + " a Palindrome? ");

     while(num >0){
        int digit = num % 10;
         reversedNumber = reversedNumber * 10 + digit;
         num = num / 10;
     }
       if(origNumber == reversedNumber){
        System.out.println(origNumber + " is a palindrome number");
       }
       else{
        System.out.println(origNumber + " is not a palindrome number");
       }
       sc.close();
    }
}
