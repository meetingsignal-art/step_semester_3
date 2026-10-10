package problems.class_problems;

import java.util.*;

abstract class Question {
    protected String type;
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String type, String questionText, String correctAnswer,
                    String studentAnswer, int points) {
        this.type = type;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double calculateScore();

    public String getType() {
        return type;
    }
}

class MCQQuestion extends Question {
    public MCQQuestion(String questionText, String correctAnswer,
                       String studentAnswer, int points) {
        super("MCQ", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String questionText, String correctAnswer,
                      String studentAnswer, int points) {
        super("TF", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer,
                         String studentAnswer, int points) {
        super("ESSAY", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;

        for (String keyword : keywords) {
            String trimmedKeyword = keyword.trim().toLowerCase();
            if (studentAnswer.toLowerCase().contains(trimmedKeyword)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Question> questions = new ArrayList<>();
        double totalScore = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            // Parse the input carefully
            String[] parts = line.split("\"");
            String type = parts[0].trim();
            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];
            int points = Integer.parseInt(parts[6].trim());

            Question question;
            switch (type) {
                case "MCQ":
                    question = new MCQQuestion(questionText, correctAnswer, studentAnswer, points);
                    break;
                case "TF":
                    question = new TFQuestion(questionText, correctAnswer, studentAnswer, points);
                    break;
                case "ESSAY":
                    question = new EssayQuestion(questionText, correctAnswer, studentAnswer, points);
                    break;
                default:
                    continue;
            }

            questions.add(question);
        }

        for (Question q : questions) {
            double score = q.calculateScore();
            totalScore += score;
            System.out.printf("%s: %.2f\n", q.getType(), score);
        }

        System.out.printf("Total Score: %.2f\n", totalScore);
        sc.close();
    }
}