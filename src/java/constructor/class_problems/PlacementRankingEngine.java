package constructor.class_problems;

import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    boolean checkEligibility() {
        return isEligible(this.cgpa) || isEligible(this.cgpa, this.codingScore);
    }

    double getCompositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    @Override
    public String toString() {
        return name + "(" + getCompositeScore() + ")";
    }
}

public class PlacementRankingEngine {
    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] eligible = Arrays.stream(candidates)
                .filter(Candidate::checkEligibility)
                .toArray(Candidate[]::new);

        Arrays.sort(eligible);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < eligible.length; i++) {
            if (i > 0) sb.append("| ");
            sb.append((i + 1)).append(". ").append(eligible[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] pool = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(pool));
    }
}
