import java.util.Scanner;
import java.time.LocalDate;

interface LibraryItem {
    LocalDate calculateDueDate(LocalDate date);
}

class Book implements LibraryItem {
    public LocalDate calculateDueDate(LocalDate date) {
        return date.plusDays(14);
    }
}

class DVD implements LibraryItem {
    public LocalDate calculateDueDate(LocalDate date) {
        return date.plusDays(7);
    }
}

class Magazine implements LibraryItem {
    public LocalDate calculateDueDate(LocalDate date) {
        return date.plusDays(3);
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LocalDate today = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.nextLine().trim();

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book();
            } else if (type.equals("DVD")) {
                item = new DVD();
            } else {
                item = new Magazine();
            }

            LocalDate dueDate = item.calculateDueDate(today);

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}