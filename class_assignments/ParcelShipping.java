import java.util.Scanner;

public class ParcelShipping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            double charge = 0;
            double insurance = 0;

            switch (type) {
                case "STANDARD":
                    charge = 40 + weight * 10;
                    break;

                case "EXPRESS":
                    charge = 80 + weight * 15;
                    insurance = value * 0.02;
                    break;

                case "FRAGILE":
                    charge = 40 + weight * 10 + 50;
                    insurance = value * 0.02;
                    break;
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}