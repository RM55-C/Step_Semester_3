
import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        public Player(String name, int matchesPlayed,
                      double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    static String draftAndRank(Player[] players) {
        Player[] shortlisted = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            if (Player.isDraftable(p.matchesPlayed)
                    || Player.isDraftable(p.matchesPlayed, p.injured)) {
                shortlisted[count++] = p;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);
        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < count; i++) {
            if (i > 0) {
                result += " | ";
            }

            result += (i + 1) + ". " + shortlisted[i].name;
        }

        return result;
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 5.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 20, 2.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}