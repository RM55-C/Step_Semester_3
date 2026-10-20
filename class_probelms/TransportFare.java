import java.util.Scanner;

interface Transport {
    double calculateFare(double distance, double factor);
}

class Bus implements Transport {
    public double calculateFare(double distance, double factor) {
        return Math.min(2 + distance * 0.10, 10);
    }
}

class Train implements Transport {
    public double calculateFare(double distance, double factor) {
        return 3 + distance * 0.15;
    }
}

class Metro implements Transport {
    public double calculateFare(double distance, double factor) {
        return (1.50 + distance * 0.20) * factor;
    }
}

public class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            double factor = 1.0;

            if (type.equals("METRO")) {
                factor = sc.nextDouble();
            }

            Transport t;

            if (type.equals("BUS")) {
                t = new Bus();
            } else if (type.equals("TRAIN")) {
                t = new Train();
            } else {
                t = new Metro();
            }

            double fare = t.calculateFare(distance, factor);
            total += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}