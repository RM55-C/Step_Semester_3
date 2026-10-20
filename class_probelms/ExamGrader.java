import java.util.Scanner;

interface Question {
    double calculateScore(String correct, String answer, int points);
}

class MCQ implements Question {
    public double calculateScore(String correct, String answer, int points) {
        return correct.equals(answer) ? points : 0;
    }
}

class TrueFalse implements Question {
    public double calculateScore(String correct, String answer, int points) {
        return correct.equals(answer) ? points : 0;
    }
}

class Essay implements Question {
    public double calculateScore(String correct, String answer, int points) {
        String[] keywords = correct.split(",");
        int matches = 0;

        for (String keyword : keywords) {
            if (answer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.nextLine();
            String correct = sc.nextLine();
            String answer = sc.nextLine();
            int points = Integer.parseInt(sc.nextLine());

            Question q;

            if (type.equals("MCQ")) {
                q = new MCQ();
            } else if (type.equals("TF")) {
                q = new TrueFalse();
            } else {
                q = new Essay();
            }

            double score = q.calculateScore(correct, answer, points);
            total += score;

            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}