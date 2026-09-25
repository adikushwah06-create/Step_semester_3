package main.java.Encapsulation.practice_problems;

public class Locker {
    private String combination;

    Locker(int Id, String combination) {
        this.combination = combination;

    }

    void changeCode(String comb, String change) {

        if (comb == combination) {
            combination = change;
            System.out.println("success, code is changed to " + combination);
        } else {
            System.out.println("rejected, code is still " + combination);
        }

    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");

    }
}
