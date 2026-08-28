package string.class_problems;

import java.util.Scanner;

public class ArmstrongChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int origNumber = number;
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number /= 10;
        }

        System.out.println("Is the number " + origNumber + " an Armstrong number? " + (sum == origNumber));
    }
}
