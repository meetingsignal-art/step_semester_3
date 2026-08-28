package string.class_problems;

import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        System.out.println("Is the number " + number + " a Prime number? " + isPrime);
    }
}
