package java_core.homework.assignment8.exercise2;

public class Program2 {
    public static void main(String[] args) {
        System.out.println("\n====== EXERCISE 2: FINAL DEMO ======");

        // Demo Q2 & Q3
        System.out.println("1. Demo Final Method (Study):");
        PrimaryStudent student1 = new PrimaryStudent(1, "Bé Nam");
        SecondaryStudent student2 = new SecondaryStudent(2, "Anh Tuấn");

        System.out.print(student1.getName() + ": ");
        student1.study(); // Gọi method final

        System.out.print(student2.getName() + ": ");
        student2.study();

        // Demo Q2: Final Variable
        System.out.println("\n2. Demo Final ID:");
        System.out.println("ID của " + student1.getName() + " là: " + student1.getId());
        // student1.id = 2; // Lỗi biên dịch: cannot assign a value to final variable id
        System.out.println("(Không thể gán lại giá trị cho ID vì là final)");
    }
}
