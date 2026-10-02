package main.java.Session_8.practice_problems;

import java.util.Scanner;

abstract class PaymentMethod {
    protected String name;

    public PaymentMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTotal(double amount);
}

class CardPayment extends PaymentMethod {
    public CardPayment() {
        super("CARD");
    }

    @Override
    public double calculateTotal(double amount) {
        return amount * 1.02;
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment() {
        super("WALLET");
    }

    @Override
    public double calculateTotal(double amount) {
        return amount * 1.01;
    }
}
class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment() {
        super("BANKTRANSFER");
    }

    @Override
    public double calculateTotal(double amount) {
        return amount;
    }
}

class PaymentMethodFactory {
    public static PaymentMethod getPaymentMethod(String type) {
        switch (type.toUpperCase()) {
            case "CARD":
                return new CardPayment();
            case "WALLET":
                return new WalletPayment();
            case "BANKTRANSFER":
                return new BankTransferPayment();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}

public class Payment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            
        
        }

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String paymentType = scanner.next();
            double amount = scanner.nextDouble();

            PaymentMethod method = PaymentMethodFactory.getPaymentMethod(paymentType);
            double adjustedAmount = method.calculateTotal(amount);

            grandTotal += adjustedAmount;

            System.out.printf("%s: %.2f%n", method.getName(), adjustedAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        scanner.close();
    }
}