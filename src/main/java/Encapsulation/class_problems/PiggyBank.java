package Encapsulation.class_problems;

public class PiggyBank {
        private double savings;
        private final String id;

        public PiggyBank(String id) {
            this.id = id;
            this.savings = 0;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                savings += amount;
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= savings) {
                savings -= amount;
                return true;
            }
            return false;
        }

        public double getSavings() {
            return savings;
        }

        public String getId() {
            return id;
        }
    }

