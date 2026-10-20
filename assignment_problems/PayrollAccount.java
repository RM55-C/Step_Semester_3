
class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Invalid salary");
            basicSalary = 0;
        }

        this.basicSalary = basicSalary;
        this.bonus = 0;
    }

    void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected");
        } else {
            bonus += amount;
        }
    }

    void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage");
        } else {
            basicSalary -= basicSalary * percent / 100;
        }
    }

    double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {
        PayrollAccount p = new PayrollAccount(50000);

        p.creditBonus(5000);
        System.out.println("Bonus credited: Rs " + p.bonus);

        p.deductTax(10);
        System.out.println("Tax deducted: 10%");

        System.out.println("Net salary: Rs " + p.getNetSalary());
    }
}
