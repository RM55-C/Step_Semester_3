import java.util.*;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double getBill();
}

class Home extends Connection {
    Home(int units) {
        super(units);
    }

    double getBill() {
        if (units <= 100)
            return units * 8.0;

        return 100 * 8.0 + (units - 100) * 7.0;
    }
}

class Shop extends Connection {
    Shop(int units) {
        super(units);
    }

    double getBill() {
        return units * 8.0 + 100;
    }
}

class Factory extends Connection {
    Factory(int units) {
        super(units);
    }

    double getBill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Connection c;

            if (type.equals("HOME")) {
                c = new Home(units);
            } else if (type.equals("SHOP")) {
                c = new Shop(units);
            } else {
                c = new Factory(units);
            }

            double bill = c.getBill();
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}