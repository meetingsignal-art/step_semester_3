package problems.assignment_problems;

import java.util.*;

abstract class Employee {
    protected String type;
    protected String name;
    protected double monthlySalary;

    public Employee(String type, String name, double monthlySalary) {
        this.type = type;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculateBonus();

    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super("FULLTIME", name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10; // 10% of salary
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super("PARTTIME", name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05; // 5% of salary
    }
}

class Intern extends Employee {
    public Intern(String name, double monthlySalary) {
        super("INTERN", name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000; // Fixed ₹2,000
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Employee> employees = new ArrayList<>();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;
            switch (type) {
                case "FULLTIME":
                    employee = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    employee = new PartTimeEmployee(name, salary);
                    break;
                case "INTERN":
                    employee = new Intern(name, salary);
                    break;
                default:
                    continue;
            }

            employees.add(employee);
        }

        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            totalBonus += bonus;
            System.out.printf("%s: %.2f\n", e.getName(), bonus);
        }

        System.out.printf("Total Bonus: %.2f\n", totalBonus);
        sc.close();
    }
}
