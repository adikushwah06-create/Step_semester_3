package main.java.Session_8.assigment_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }

    public String getName() {
        return name;
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 30; 
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 90; 
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 365; 
    }
}

public class Streaming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) ;

        int n = Integer.parseInt(scanner.nextLine().trim());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String planType = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2], formatter);

            SubscriptionPlan plan;
            switch (planType) {
                case "BASIC":
                    plan = new BasicPlan(name, startDate);
                    break;
                case "STANDARD":
                    plan = new StandardPlan(name, startDate);
                    break;
                case "PREMIUM":
                    plan = new PremiumPlan(name, startDate);
                    break;
                default:
                    continue;
            }

            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.println(plan.getName() + ": " + renewalDate.format(formatter));
        }

        scanner.close();
    }
}