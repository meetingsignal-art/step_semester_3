package Encapsulation.class_problems;

public class Scorecard {
        private boolean[] results;
        private int count;
        private int score;

        public Scorecard(int totalQuestions) {
            results = new boolean[totalQuestions];
            count = 0;
            score = 0;
        }

        public void recordAnswer(boolean isCorrect) {
            if (count < results.length) {
                results[count] = isCorrect;
                if (isCorrect) {
                    score++;
                }
                count++;
            }
        }

        public int getScore() {
            return score;
        }
    }

