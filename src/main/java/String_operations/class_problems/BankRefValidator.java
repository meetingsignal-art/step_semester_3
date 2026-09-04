package String_operations.class_problems;

import java.util.Scanner;

public class BankRefValidator {

    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() >= 3) {
            return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        }
        return trimmed.toUpperCase();
    }

    public static String validateAndFormat(String ref) {
        if (ref.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(ref.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(ref.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(ref.substring(0, 3)).append("] DATE: ")
                .append(ref.substring(3, 9)).append(" | SEQ: ")
                .append(ref.substring(9));

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String normalized = normalizeReference(input);
        System.out.println(validateAndFormat(normalized));
    }
}
