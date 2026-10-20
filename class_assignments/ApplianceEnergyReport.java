import java.util.Scanner;

public class ApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String appliance = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                String next = sc.next();

                if (next.equals("SAVER")) {
                    saver = true;
                } else {
                    // The next appliance is not a SAVER option.
                    // This input format needs line-based reading.
                }
            }

            double power = 0;

            switch (appliance) {
                case "FRIDGE":
                    power = 150;
                    break;
                case "AC":
                    power = 1500;
                    break;
                case "TV":
                    power = 100;
                    break;
                case "WASHER":
                    power = 500;
                    break;
            }

            if (saver && (appliance.equals("FRIDGE") ||
                         appliance.equals("AC"))) {
                double units = power * hours / 1000 * 0.75;
                double cost = units * 8;
                total += cost;

                System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    appliance, units, cost
                );
            } else if (saver) {
                System.out.printf(
                    "%s: saver mode not supported%n", appliance
                );
            } else {
                double units = power * hours / 1000;
                double cost = units * 8;
                total += cost;

                System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    appliance, units, cost
                );
            }
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}