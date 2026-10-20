
class Employe {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employe(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        Employe e1 = new Employe("Divya", 65000);
        Employe e2 = new Employe("Arjun", 55000);
        Employe e3 = new Employe("Priya", 70000);

        Employe.printCompanyInfo();
    }
}
