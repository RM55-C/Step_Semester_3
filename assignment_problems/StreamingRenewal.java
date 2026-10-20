public class StreamingRenewal {
    
}
import java.util.Scanner;
import java.time.LocalDate;

abstract class Subscription {
    String name;
    LocalDate startDate;

    Subscription(String name, String startDate) {
        this.name = name;
        this.startDate = LocalDate.parse(startDate);
    }

    abstract int getDays();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(getDays());
    }
}

class Basic extends Subscription {
    Basic(String name, String date) {
        super(name, date);
    }

    int getDays() {
        return 30;
    }
}

class Standard extends Subscription {
    Standard(String name, String date) {
        super(name, date);
    }

    int getDays() {
        return 90;
    }
}

class Premium extends Subscription {
    Premium(String name, String date) {
        super(name, date);
    }

    int getDays() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            Subscription s;

            if (type.equals("BASIC"))
                s = new Basic(name, date);
            else if (type.equals("STANDARD"))
                s = new Standard(name, date);
            else
                s = new Premium(name, date);

            System.out.println(s.name + ": " + s.calculateRenewalDate());
        }

        sc.close();
    }
}
