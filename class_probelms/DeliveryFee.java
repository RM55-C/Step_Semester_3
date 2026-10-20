import java.util.Scanner;

interface Delivery {
    double calculateFee(double weight, double distance, double extra);
}

class StandardDelivery implements Delivery {
    public double calculateFee(double weight, double distance, double extra) {
        return 5 + weight * 0.50 + distance * 0.10;
    }
}

class ExpressDelivery implements Delivery {
    public double calculateFee(double weight, double distance, double extra) {
        return 15 + weight * 1.00 + distance * 0.20;
    }
}

class InternationalDelivery implements Delivery {
    public double calculateFee(double weight, double distance, double extra) {
        return 25 + weight * 2.00 + distance * 0.50 + extra;
    }
}

public class DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            double extra = 0;

            if (type.equals("INTERNATIONAL")) {
                extra = sc.nextDouble();
            }

            Delivery d;

            if (type.equals("STANDARD")) {
                d = new StandardDelivery();
            } else if (type.equals("EXPRESS")) {
                d = new ExpressDelivery();
            } else {
                d = new InternationalDelivery();
            }

            double fee = d.calculateFee(weight, distance, extra);
            total += fee;

            System.out.printf("%s: %.2f%n", type, fee);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}