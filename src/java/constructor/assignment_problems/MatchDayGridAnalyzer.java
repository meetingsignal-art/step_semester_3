package constructor.assignment_problems;

public class MatchDayGridAnalyzer {

    // Private helper to compute average of a single match row
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0;

        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String classification = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) result.append("| ");
            result.append("Match ").append(i).append(": ").append(classification);
        }

        return result.toString();
    }

    // Test harness
    public static void main(String[] args) {
        int[][] matches = {
                {4, 6, 8},      // Avg = 6.0
                {10, 12, 14},   // Avg = 12.0
                {2, 3, 1}       // Avg = 2.0
        };
        System.out.println(classifyMatches(matches, 8));
        // Expected: Match 0: Normal| Match 1: Power Surge| Match 2: Normal
    }
}
