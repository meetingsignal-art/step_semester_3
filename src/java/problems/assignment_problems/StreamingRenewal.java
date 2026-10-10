package problems.assignment_problems;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class SubscriptionPlan {
    protected String type;
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String type, String name, LocalDate startDate) {
        this.type = type;
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
        super("BASIC", name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super("STANDARD", name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super("PREMIUM", name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<SubscriptionPlan> subscribers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate startDate = LocalDate.parse(dateStr, formatter);

            SubscriptionPlan plan;
            switch (type) {
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

            subscribers.add(plan);
        }

        for (SubscriptionPlan p : subscribers) {
            LocalDate renewalDate = p.calculateRenewalDate();
            System.out.println(p.getName() + ": " + renewalDate.format(formatter));
        }

        sc.close();
    }
}
