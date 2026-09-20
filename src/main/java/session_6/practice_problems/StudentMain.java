package main.java.session_6.practice_problems;

class Student {
   
    String name;
    double attendance;

   
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

   
    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class StudentMain {
    public static void main(String[] args) {
       
         new Student("Aarav", 85.5);
         new Student("Diya", 92.0);

        
        Student.printCollegeInfo();
    }
}