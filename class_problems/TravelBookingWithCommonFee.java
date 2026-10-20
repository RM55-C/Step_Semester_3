import java.util.*;

abstract class Booking {
    double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double getFare();
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }

    double getFare() {
        return distance * 2.0 + 50;
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }

    double getFare() {
        return distance * 1.5 + 50;
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }

    double getFare() {
        return 2500 + distance * 4.0 + 50;
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Booking b;

            if (mode.equals("BUS")) {
                b = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                b = new Train(distance);
            } else {
                b = new Flight(distance);
            }

            System.out.printf("%s: %.2f%n",
                    mode, b.getFare());
        }
    }
}