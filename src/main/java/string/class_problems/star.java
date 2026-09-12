package main.java.string.class_problems;
import java.util.Scanner;

public class star {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter number of rows");
       int rows = sc.nextInt();

       System.out.println("The right-angled triangle pattern for " + rows + " is " + rows);
       for(int i=1; i<=rows; i++){
        for(int j=1; j<=i; j++){
            System.out.print("*");
        }
       System.out.println();
       }
       sc.close();
    }
}
