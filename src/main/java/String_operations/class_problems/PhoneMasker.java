package String_operations.class_problems;

import java.util.Scanner;

public class PhoneMasker {
    public static String maskPhoneNumber(String phone) {
        String trimmed = phone.trim();

        if (trimmed.length() != 10) {
            return "Invalid phone number";
        }

        for (char c : trimmed.toCharArray()) {
            if (!Character.isDigit(c)) {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX-").append(trimmed.substring(6));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(maskPhoneNumber(sc.nextLine()));
    }
}
