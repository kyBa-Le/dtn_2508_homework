package java_core.homework.assignment4.com.vti.entity.Exercise6;

public class Waiter extends User {
    public Waiter(String name, double salaryRatio) {
        super(name, salaryRatio);
    }

    @Override
    public double calculatePay() {
        return getSalaryRatio() * 220;
    }
}
