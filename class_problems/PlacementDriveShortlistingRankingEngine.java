import java.util.Arrays;

public class PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 8.0;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        public int compareTo(Candidate other) {
            double score1 = cgpa * 10 + codingScore * 0.5;
            double score2 = other.cgpa * 10 + other.codingScore * 0.5;
            return Double.compare(score2, score1);
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.cgpa) ||
                Candidate.isEligible(c.cgpa, c.codingScore)) {
                shortlisted[count++] = c;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);
        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < count; i++) {
            if (i > 0) result += " | ";

            double score = shortlisted[i].cgpa * 10
                    + shortlisted[i].codingScore * 0.5;

            result += (i + 1) + ". " + shortlisted[i].name
                    + " (" + score + ")";
        }

        return result;
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}