package main.java.Encapsulation.practice_problems;

public class AttendanceSheet {

    private final String[] presentStudents;

    private int count = 0;

    public AttendanceSheet(int total) {
        this.presentStudents = new String[total];
    }

    public boolean isPresent(String pre) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(pre)) {
                return true;
            }
        }
        return false;
    }

   

    public void markPresent(String name) {

        if (isPresent(name)) {
            System.out.println("true");
            return;
        }
        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }

    }

     void getPresentCount() {
        System.out.println("present count -> " + count);
    }


    
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("aditi");
        sheet.markPresent("ashly");
        sheet.markPresent("ammoditaa");
        sheet.markPresent("aditi");
        sheet.getPresentCount();
        sheet.isPresent("ammoditaa");
    }
}
