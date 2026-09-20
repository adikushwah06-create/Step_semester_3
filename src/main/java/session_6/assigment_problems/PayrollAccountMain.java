package main.java.session_6.assigment_problems;

class PayrollAccount {
   
    private double basicSalary;
    private double bonus;

   
    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Initialized to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0;
    }

   
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Rejected: Bonus amount must be greater than 0.");
            return;
        }
        this.bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

   
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Rejected: Tax percent must be between 0 and 100.");
            return;
        }
        double taxAmount = (this.basicSalary * percent) / 100.0;
        this.basicSalary -= taxAmount;
        System.out.println("Tax deducted: " + (int) percent + "%");
    }

   
    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}

public class PayrollAccountMain {
    public static void main(String[] args) {
        
        PayrollAccount account = new PayrollAccount(50000);

        account.creditBonus(5000);
        account.deductTax(10);

        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}