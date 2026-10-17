package main.java.session_10.assignment_problems;
import java.util.Scanner;

public class Attendance  {

    int present=0;
    int currentstreak=0;
    int maxstreak=0;

    void attendanceSummary(int[] days){
       for(int i=0; i<days.length; i++){
         if(days[i] == 1){
            present++;
            currentstreak++;

            if(currentstreak > maxstreak){
            maxstreak=currentstreak;
           }
         }
         else{
            currentstreak=0;
         }
     
         }
          System.out.println("Present: " + present + ", Longest streak: " + maxstreak);
       }


    public static void main(String[] args){
         Scanner sc = new Scanner(System.in);

         System.out.println("Enter number of days: ");
         int n = sc.nextInt();

         if( n < 1 || n > 100){
            System.out.println("Number of days should be between 1 and 100 only");
         }

         int[] days = new int[n];

         System.out.println("Enter present or absent for " + n + " days");

         for(int i=0; i<n; i++){
            days[i] = sc.nextInt();

            if(days[i] != 0 && days[i] != 1){
                System.out.println("Enter either 0 or 1");
            }
         }

         Attendance ac = new Attendance();
         ac.attendanceSummary(days);

         sc.close();
    }
}
