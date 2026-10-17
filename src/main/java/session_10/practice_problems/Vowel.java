package main.java.session_10.practice_problems;
import java.util.Scanner;

public class Vowel {
    public static void main(String[] args){

        int vowelcount=0;
        int consonentcount=0;
       System.out.println("Enter the word: ");

       Scanner sc = new Scanner(System.in);
       String word = sc.nextLine().toLowerCase();

       for(int i=0; i<word.length(); i++){
       char p=  word.charAt(i);

        if( p == 'a' || p == 'e' || p== 'i' || p=='o' || p=='u'){
            vowelcount++;
        }
        else{
            consonentcount++;
        }
       }

       System.out.println("vowels: "+ vowelcount + " consonents: "+ consonentcount);

       sc.close();
    }
}
