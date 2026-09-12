package main.java.string.class_problems;
import java.util.Scanner;

public class prime {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num");
        int num = sc.nextInt();

        boolean isPrime= true;

        for(int i=2; i<num; i++ ){
            if(num%i == 0){
                isPrime=false;
                break;
            }
        }

        System.out.println("Is the number " + num + " a Prime number? " + isPrime);

        sc.close();
    } 
    
}
