import java.util.Scanner;

interface Payment {
    double calculate(double amount);
}

class CardPayment implements Payment {
    public double calculate(double amount) {
        return amount * 1.02;
    }
}

class WalletPayment implements Payment {
    public double calculate(double amount) {
        return amount * 1.01;
    }
}

class BankTransfer implements Payment {
    public double calculate(double amount) {
        return amount;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment p;

            if (type.equals("CARD")) {
                p = new CardPayment();
            } else if (type.equals("WALLET")) {
                p = new WalletPayment();
            } else {
                p = new BankTransfer();
            }

            double adjusted = p.calculate(amount);
            total += adjusted;

            System.out.printf("%s: %.2f%n", type, adjusted);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}