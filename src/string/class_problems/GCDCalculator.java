package string.class_problems;

import java.util.Scanner;

public class GCDCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int originalNum1 = number1;
        int originalNum2 = number2;

        while (number2 != 0) {
            int remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }

        System.out.println("The GCD of " + originalNum1 + " and " + originalNum2 + " is " + number1);
    }
}
