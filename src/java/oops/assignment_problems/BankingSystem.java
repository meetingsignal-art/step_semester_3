package oops.assignment_problems;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return true;
        }
        System.out.println("Insufficient funds or invalid amount");
        return false;
    }

    double getBalance() {
        return balance;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC123", 10000);
        acc.deposit(5000);
        acc.withdraw(3000);
        System.out.println("Current Balance: " + acc.getBalance());
    }
}