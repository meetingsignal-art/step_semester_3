package string.assignment_problems;

public class GuessTheNumberGame {
    public static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tryCount = 0;
        boolean guessed = false;

        while (tryCount < maxTries && !guessed) {
            int guess = guesses[tryCount];
            if (guess == secretNumber) {
                System.out.println("Correct! You guessed it");
                guessed = true;
            } else if (guess > secretNumber) {
                System.out.println("Too high");
            } else {
                System.out.println("Too low");
            }
            tryCount++;
        }

        if (!guessed) {
            System.out.println("Out of tries — the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        guessTheNumber(42, 4, new int[]{20, 60, 42});
    }
}