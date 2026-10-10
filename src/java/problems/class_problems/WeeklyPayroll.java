package problems.class_problems;

import java.util.*;

abstract class StaffMember {
    protected String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public abstract double calculatePay();
    public String getName() { return name; }
}

class FullTimeStaff extends StaffMember {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private int hours;
    private double rate;

    public HourlyStaff(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

class Intern extends StaffMember {
    private double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyPayroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<StaffMember> staffList = new ArrayList<>();
        double totalPay = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            StaffMember staff = null;
            switch (type) {
                case "FULLTIME":
                    double salary = sc.nextDouble();
                    staff = new FullTimeStaff(name, salary);
                    break;
                case "HOURLY":
                    int hours = sc.nextInt();
                    double rate = sc.nextDouble();
                    staff = new HourlyStaff(name, hours, rate);
                    break;
                case "INTERN":
                    double stipend = sc.nextDouble();
                    staff = new Intern(name, stipend);
                    break;
            }

            if (staff != null) staffList.add(staff);
        }

        for (StaffMember s : staffList) {
            double pay = s.calculatePay();
            totalPay += pay;
            System.out.printf("%s: %.2f\n", s.getName(), pay);
        }

        System.out.printf("Total Payroll: %.2f\n", totalPay);
        sc.close();
    }
}