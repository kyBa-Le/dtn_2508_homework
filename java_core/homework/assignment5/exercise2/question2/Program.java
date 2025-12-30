package java_core.homework.assignment5.exercise2.question2;

public class Program {
    public static void main(String[] args) {
        System.out.println("=== Demo Person và Student ===");

        Student sv = new Student();
        System.out.println("\nNhập thông tin sinh viên:");
        sv.inputInfo();

        System.out.println("\n--- Thông tin sinh viên đã nhập ---");
        sv.showInfo();

        System.out.println("\nKết quả xét học bổng:");
        if (sv.coHocBong()) {
            System.out.println("Sinh viên " + sv.getTen() + " ĐƯỢC học bổng!");
        } else {
            System.out.println("Sinh viên " + sv.getTen() + " KHÔNG được học bổng.");
        }
    }
}