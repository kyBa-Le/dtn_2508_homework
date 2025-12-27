package java_core.homework.assignment4.com.vti.entity.Exercise6;

public abstract class User {
    private String name;
    private double salaryRatio;

    public User(String name, double salaryRatio) {
        this.name = name;
        this.salaryRatio = salaryRatio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalaryRatio() {
        return salaryRatio;
    }

    public void setSalaryRatio(double salaryRatio) {
        this.salaryRatio = salaryRatio;
    }

    // Abstract method
    public abstract double calculatePay();

    public void displayInfo() {
        System.out.printf("Tên: %s | Hệ số lương: %.2f | Thu nhập: %.0f VND%n",
                name, salaryRatio, calculatePay());
    }
}
