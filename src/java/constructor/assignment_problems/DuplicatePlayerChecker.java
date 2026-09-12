package constructor.assignment_problems;

public class DuplicatePlayerChecker {

    public static String findDuplicatePick(String[] playerNames) {
        // Compare every name against every subsequent name
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                // Case-sensitive comparison as per constraints
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    // Test harness
    public static void main(String[] args) {
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};

        System.out.println(findDuplicatePick(lineup1)); // Duplicate Found: Kohli
        System.out.println(findDuplicatePick(lineup2)); // No Duplicates Found
    }
}
