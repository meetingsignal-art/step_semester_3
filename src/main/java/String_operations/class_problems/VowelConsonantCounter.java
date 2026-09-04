package String_operations.class_problems;

import java.util.Scanner;

public class VowelConsonantCounter {
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char c = lowerText.charAt(i);
            if (c == ' ') continue;

            if ("aeiou".indexOf(c) != -1) {
                vowels++;
            } else {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        countVowelsAndConsonants(sc.nextLine());
    }
}