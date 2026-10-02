package main.java.Session_8.practice_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double evaluateScore();
    public abstract String getQuestionType();
}

class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0.0;
    }

    @Override
    public String getQuestionType() {
        return "MCQ";
    }
}

class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
    }

    @Override
    public String getQuestionType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        String lowerStudentAnswer = studentAnswer.toLowerCase();
        String[] keywords = correctAnswer.split(",");
        int matchedKeywords = 0;

        for (String keyword : keywords) {
            String trimmed = keyword.trim().toLowerCase();
            if (!trimmed.isEmpty() && lowerStudentAnswer.contains(trimmed)) {
                matchedKeywords++;
            }
        }

        if (matchedKeywords >= 2) {
            return points * 0.75; // Award 75% for 2 or more keywords
        } else if (matchedKeywords == 1) {
            return points * 0.50; // Award 50% for 1 keyword
        } else {
            return 0.0;
        }
    }

    @Override
    public String getQuestionType() {
        return "ESSAY";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) ;

        int n = Integer.parseInt(scanner.nextLine().trim());
        double overallScore = 0.0;

        // Regex matches the type, three quoted string arguments, and points at the end
        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+(?:\\.\\d+)?)$");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            Matcher matcher = pattern.matcher(line);
            if (!matcher.matches()) continue;

            String type = matcher.group(1);
            String questionText = matcher.group(2);
            String correctAnswer = matcher.group(3);
            String studentAnswer = matcher.group(4);
            double points = Double.parseDouble(matcher.group(5));

            Question question;
            switch (type) {
                case "MCQ":
                    question = new MultipleChoiceQuestion(questionText, correctAnswer, studentAnswer, points);
                    break;
                case "TF":
                    question = new TrueFalseQuestion(questionText, correctAnswer, studentAnswer, points);
                    break;
                case "ESSAY":
                    question = new EssayQuestion(questionText, correctAnswer, studentAnswer, points);
                    break;
                default:
                    continue;
            }

            double score = question.evaluateScore();
            overallScore += score;

            System.out.printf("%s: %.2f\n", question.getQuestionType(), score);
        }

        System.out.printf("Total Score: %.2f\n", overallScore);
        scanner.close();
    }
}