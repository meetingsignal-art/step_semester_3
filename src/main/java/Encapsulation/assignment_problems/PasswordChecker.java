package Encapsulation.assignment_problems;

class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}