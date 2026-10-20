import java.util.Scanner;

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            double price;

            switch (seat) {
                case "REGULAR":
                    price = 150;
                    break;
                case "PREMIUM":
                    price = 250;
                    break;
                default:
                    price = 400;
            }

            double amount = (price + 20) * count;
            total += amount;

            System.out.printf("%s: %.2f%n", seat, amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}