package main.java.Encapsulation.practice_problems;

public class PiggyBank {
    private String Id;
    private double savings = 0;

    public PiggyBank(String Id) {
        this.Id = Id;
    }

    void deposit(double deposit) {
        savings += deposit;
        System.out.println("after deposit savings " + savings);
    }

    void withdraw(double withdraw) {

        if (savings <= withdraw)

        {
            System.out.println("Not enough savings to withdraw");
        } else {
            savings -= withdraw;
            System.out.println("after withdraw savings " + savings);

        }
    }

    void savings() {
        System.out.println("ID " + Id);
        System.out.println("savings " + savings);

    }

    public static void main(String[] args) {

        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
        pb.savings();
    }
}
