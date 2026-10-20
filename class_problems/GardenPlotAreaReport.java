import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double getArea();
    abstract String getShape();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double getArea() {
        return length * width;
    }

    String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double getArea() {
        return 0.5 * base * height;
    }

    String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();

            Plot p;

            if (type.equals("CIRCLE")) {
                p = new Circle(owner, sc.nextDouble());
            } else if (type.equals("RECTANGLE")) {
                p = new Rectangle(owner, sc.nextDouble(),
                                  sc.nextDouble());
            } else {
                p = new Triangle(owner, sc.nextDouble(),
                                 sc.nextDouble());
            }

            double area = p.getArea();
            total += area;

            System.out.printf("%s (%s): %.2f%n",
                    p.owner, p.getShape(), area);
        }

        System.out.printf("Total Area: %.2f%n", total);
    }
}