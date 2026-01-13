package java_core.homework.assignment8.exercise1;

import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n====== EXERCISE 1: STATIC DEMO ======");
            System.out.println("1. Question 1 & 4: Static Variable (College)");
            System.out.println("2. Question 2: Money Group (Quỹ lớp)");
            System.out.println("3. Question 3: MyMath Static Methods");
            System.out.println("4. Question 5: Student Counter");
            System.out.println("0. Exit");
            System.out.print("Mời bạn chọn: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    question1And4();
                    break;
                case 2:
                    question2();
                    break;
                case 3:
                    question3();
                    break;
                case 4:
                    question5();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chọn sai, vui lòng chọn lại!");
            }
        }
    }

    // Demo Q1 & Q4: Thay đổi trường học chung
    public static void question1And4() {
        System.out.println("\n--- Q1 & Q4: STATIC COLLEGE ---");
        Student[] students = {
                new Student(1, "Nguyễn Văn A"),
                new Student(2, "Nguyễn Văn B"),
                new Student(3, "Nguyễn Văn C")
        };

        System.out.println("--> Trước khi chuyển trường:");
        for (Student s : students)
            System.out.println(s);

        // Chuyển trường
        Student.setCollege("Đại học công nghệ");

        System.out.println("--> Sau khi chuyển trường:");
        for (Student s : students)
            System.out.println(s);
    }

    // Demo Q2: Quỹ lớp
    public static void question2() {
        System.out.println("\n--- Q2: MONEY GROUP ---");
        // Giả lập các bước theo đề bài
        System.out.println("B1: 3 Student nộp quỹ (100k/người)...");
        Student.nopQuy(100 * 3);

        System.out.println("B2: Student 1 mua bim bim...");
        Student.rutQuy(50, "mua bim bim");

        System.out.println("B3: Student 2 mua bánh mì...");
        Student.rutQuy(20, "mua bánh mì");

        System.out.println("B4: Student 3 mua đồ dùng học tập...");
        Student.rutQuy(150, "mua đồ dùng");

        System.out.println("B5: Cả nhóm đóng thêm (50k/người)...");
        Student.nopQuy(50 * 3); // 3 người
    }

    // Demo Q3: MyMath
    public static void question3() {
        System.out.println("\n--- Q3: MY MATH ---");
        int a = 5, b = 7;
        System.out.println("Min(" + a + ", " + b + ") = " + MyMath.min(a, b));
        System.out.println("Sum(" + a + ", " + b + ") = " + MyMath.sum(a, b));
    }

    // Demo Q5: Counter
    public static void question5() {
        System.out.println("\n--- Q5: STUDENT COUNTER ---");
        // Biến count lưu tổng số student đã khởi tạo từ đầu chương trình
        System.out.println("Số lượng Student đã được sinh ra: " + Student.count);
    }
}
