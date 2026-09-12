package constructor.assignment_problems;
import java.util.Arrays;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Overloaded method 1: Experience-only rule for established players
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overloaded method 2: Combined fitness & experience rule
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return !injured && matchesPlayed >= 5;
    }

    // Instance method to check draftability using both rules
    public boolean canBeDrafted() {
        // Established players qualify regardless of injury
        if (isDraftable(this.matchesPlayed)) return true;
        // Newer players need fitness + minimum experience
        return isDraftable(this.matchesPlayed, this.injured);
    }

    // Sort by fantasy points DESCENDING (using battingAverage as proxy)
    @Override
    public int compareTo(Player other) {
        // Reverse order for descending sort
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    public String getName() { return name; }
}

public class AutoDraftRankingEngine {

    public static String draftAndRank(Player[] players) {
        // Step 1: Filter draftable players
        int count = 0;
        for (Player p : players) {
            if (p.canBeDrafted()) count++;
        }

        Player[] draftable = new Player[count];
        int idx = 0;
        for (Player p : players) {
            if (p.canBeDrafted()) {
                draftable[idx++] = p;
            }
        }

        // Step 2: Sort using Comparable (descending by batting average)
        Arrays.sort(draftable);

        // Step 3: Build ranked output string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) sb.append("| ");
            sb.append((i + 1)).append(". ").append(draftable[i].getName());
        }

        return sb.toString();
    }

    // Test harness
    public static void main(String[] args) {
        Player[] squad = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(squad));
        // Expected: 1. Rahul| 2. Virat| 3. Dev
        // Sameer excluded (fails both rules), Dev included (experience >= 10)
    }
}
