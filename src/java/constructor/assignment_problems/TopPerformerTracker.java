package constructor.assignment_problems;

public class TopPerformerTracker {

    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            return "Invalid Input";
        }

        int min = scores[0];
        int max = scores[0];

        // Single pass through the array
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + "| Max: " + max + "| Spread: " + spread;
    }

    // Test harness
    public static void main(String[] args) {
        int[] weeklyScores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(weeklyScores));
        // Expected: Min: 33| Max: 90| Spread: 57
    }
}
