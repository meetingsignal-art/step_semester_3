package oops.assignment_problems;

class Employee {
    String name;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String name) {
        this.name = name;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName + " Employees on record: " + employeeCount);
    }
}

public class CompanyRegistry {
    public static void main(String[] args) {
        new Employee("Alice");
        new Employee("Bob");
        new Employee("Charlie");
        Employee.printCompanyInfo();
    }
}
