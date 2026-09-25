package main.java.Encapsulation.practice_problems;


public class ScoreCard {
    private final boolean[] answers;

    private int count=0;

    public ScoreCard(int totalques){

        this.answers= new boolean[totalques];
    }

    public void recordAnswer(boolean answer){
        if (count < answers.length ){
            answers[count]= answer;
            count++;
        }
        else {
            System.out.println("All questions have already been recorded.");
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < count; i++) {
            if (answers[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        ScoreCard sc = new ScoreCard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("sc.getScore() -> " + sc.getScore());
    }
}

     
    

