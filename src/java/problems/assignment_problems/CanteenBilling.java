package problems.assignment_problems;

import java.util.*;

abstract class Customer {
    protected String type;
    protected double billAmount;

    public Customer(String type, double billAmount) {
        this.type = type;
        this.billAmount = billAmount;
    }

    public abstract double calculateFinalAmount();

    public String getType() {
        return type;
    }
}

class Student extends Customer {
    public Student(double billAmount) {
        super("STUDENT", billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.90; // 10% discount
    }
}

class Staff extends Customer {
    public Staff(double billAmount) {
        super("STAFF", billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.95; // 5% discount
    }
}

class Guest extends Customer {
    public Guest(double billAmount) {
        super("GUEST", billAmount);
    }

    @Override
    public double calculateFinalAmount() {
        return billAmount + 10; // Full amount + ₹10 service charge
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Customer> customers = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;
            switch (type) {
                case "STUDENT":
                    customer = new Student(amount);
                    break;
                case "STAFF":
                    customer = new Staff(amount);
                    break;
                case "GUEST":
                    customer = new Guest(amount);
                    break;
                default:
                    continue;
            }

            customers.add(customer);
        }

        for (Customer c : customers) {
            double finalAmount = c.calculateFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f\n", c.getType(), finalAmount);
        }

        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}