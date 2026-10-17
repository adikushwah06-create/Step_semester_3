package main.java.session_10.practice_problems;

import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    public char calculateGrade(double avg) {
        if (avg >= 75.0) {
            return 'B';
        } else if (avg >= 60.0) {
            return 'C';
        } else if (avg >= 40.0) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void displayResultCard() {
        double avg = calculateAverage();
        char grade = calculateGrade(avg);
        System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), avg, grade);
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reads input lines in the format: Asha [80, 90, 70]
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            int bracketStart = line.indexOf('[');
            int bracketEnd = line.indexOf(']');

            if (bracketStart != -1 && bracketEnd != -1) {
                String name = line.substring(0, bracketStart).trim();
                String marksPart = line.substring(bracketStart + 1, bracketEnd).trim();

                String[] markTokens = marksPart.split(",");
                int[] marks = new int[markTokens.length];
                for (int i = 0; i < markTokens.length; i++) {
                    marks[i] = Integer.parseInt(markTokens[i].trim());
                }

                Student student = new Student(name, marks);
                student.displayResultCard();
            }
        }

        sc.close();
    }
}