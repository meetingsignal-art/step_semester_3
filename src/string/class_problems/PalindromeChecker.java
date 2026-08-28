package string.class_problems;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int origNumber = number;
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        System.out.println("Is the number " + origNumber + " a Palindrome? " + (reversedNumber == origNumber));
    }
}