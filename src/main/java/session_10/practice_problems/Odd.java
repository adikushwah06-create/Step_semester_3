package main.java.session_10.practice_problems;

import java.util.Scanner;

public class Odd {
    public static void main(String[] args){

        System.out.println("Enter array size");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        int[] array = new int[n];

        int Oddcount=0;
        int Evencount=0;

         System.out.println("Enter " + n + " values: ");

         for(int i=0; i<array.length; i++){
            array[i]= sc.nextInt();

            if(array[i] % 2 == 0){
                Oddcount++;
            }
            else{
                Evencount++;
            }
         }

        System.out.println("Odd: " + Oddcount + " Even: " + Evencount);
        sc.close();
    }

}
