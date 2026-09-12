package constructor.assignment_problems;

public class FantasyTeamMultiplier {

    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        // Apply 2x multiplier to Captain
        playerScores[captainIndex] = playerScores[captainIndex] * 2;

        // Apply 1.5x multiplier to Vice-Captain
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
    }

    // Test harness
    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);

        // Expected Output: [40.0, 110.0, 30.0, 93.0]
        System.out.print("[");
        for(int i=0; i<scores.length; i++) {
            System.out.print(scores[i]);
            if(i < scores.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
