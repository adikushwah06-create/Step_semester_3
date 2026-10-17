package main.java.session_10.assignment_problems;
import java.util.Scanner;

public class Bus {

    int rows,columns;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int rows,columns;
        

        System.out.println("Enter number of rows: ");

        rows= sc.nextInt();

        if(rows < 1 || rows >10){
           System.out.println("rows out of constraint");
        }
        

        System.out.println("Enter number of columns: ");
        columns= sc.nextInt();

        
        if(columns < 1 || columns > 10){
            System.out.println("columns out of constraint");
        }
        

       int[][] grid= new int[rows][columns];
        
       System.out.println("Enter grid values row by row:");
        for(int i=0; i<rows; i++){
          for(int j=0; j<columns; j++){
              grid[i][j]= sc.nextInt();

            if(grid[i][j] <0 || grid[i][j] > 3){
             System.out.println("each grid value has to be between 0 and 3");
            }
            
          }
        }

        
        int maxtotal= -1;
        int bestrow =0;

        for(int i=0; i<rows; i++){
            int sumrow=0;
          for(int j=0; j<columns; j++){
            sumrow += grid[i][j];
          }
          if(sumrow > maxtotal){
            maxtotal = sumrow;
            bestrow = i;
          }
      
        }

        System.out.println("row: " + bestrow + "     " + "total: " + maxtotal);


    sc.close();

        
    
    }
}
