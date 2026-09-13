package oops.assignment_problems;

class Employee {
    private double basicSalary;
    private double bonus;

    public Employee(double basicSalary) {
        this.basicSalary = basicSalary;
        this.bonus = 0;
    }

    void creditBonus(double amount) {
        if (amount > 0) {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    void deductTax(double percent) {
        if (percent >= 0 && percent <= 100) {
            basicSalary -= basicSalary * (percent / 100);
            System.out.println("Tax deducted: " + percent + "%");
        } else {
            System.out.println("Invalid tax percentage.");
        }
    }

    double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class SalaryManager {
    public static void main(String[] args) {
        Employee emp = new Employee(50000);
        emp.creditBonus(5000);
        emp.deductTax(10);
        System.out.println("Net salary: Rs " + emp.getNetSalary());
    }
}
