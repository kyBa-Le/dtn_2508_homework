package java_core.homework.assignment8.exercise5;

import java_core.homework.assignment8.entity.Student;
import java_core.homework.assignment8.utils.FileManager;
import java_core.homework.assignment8.utils.IOManager;

import java.util.Scanner;

public class Program {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n====== EXERCISE 3, 4, 5 DEMO ======");
            System.out.println("1. Demo File Manager (Create/Check file)");
            System.out.println("2. Demo IO Stream (Write/Read Object)");
            System.out.println("3. Exercise 5: Student IO Demo");
            System.out.println("0. Exit");
            System.out.print("Mời bạn chọn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        demoFileManager();
                        break;
                    case 2:
                        demoIOStream();
                        break;
                    case 3:
                        exercise5Question1();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Chọn sai, vui lòng chọn lại!");
                }
            } catch (Exception e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
    }

    // Demo Exercise 3: File Manager
    private static void demoFileManager() {
        try {
            String testFile = "TestFile.txt";
            System.out.println("--- 1. Check exists: " + FileManager.isFileExists(testFile));

            System.out.println("--- 2. Create New File ---");
            if (!FileManager.isFileExists(testFile)) {
                FileManager.createNewFile(testFile);
            }

            System.out.println("--- 3. Check exists again: " + FileManager.isFileExists(testFile));

            // Xóa để dọn dẹp (nếu cần demo delete)
            // FileManager.deleteFile(testFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Demo Exercise 4: IO Stream (Object)
    private static void demoIOStream() {
        try {
            System.out.println("--- Write Object Student ---");
            Student s = new Student(99, "Demo Object");
            IOManager.writeObject(s, ".", "StudentObj.ser");

            System.out.println("--- Read Object Student ---");
            Student sRead = (Student) IOManager.readObject("./StudentObj.ser");
            System.out.println("Kết quả đọc: " + sRead);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Exercise 5 - Question 1: Student IO
    private static void exercise5Question1() {
        System.out.println("\n--- EXERCISE 5: NHẬP VÀ GHI FILE STUDENT ---");
        try {
            Student[] students = new Student[3];

            // a) Khởi tạo 3 instance từ console
            for (int i = 0; i < 3; i++) {
                System.out.println("Nhập thông tin Student " + (i + 1) + ":");
                System.out.print("ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Name: ");
                String name = scanner.nextLine();
                students[i] = new Student(id, name);
            }

            // b) Write 3 student này ra file StudentInformation.txt
            String filePath = "StudentInformation.txt";
            String content = "";
            for (Student s : students) {
                content += s.toString() + "\n";
            }

            // isContinuing = false để ghi đè mới
            IOManager.writeFile(filePath, content, false);

            // c) Đọc thông tin file và in ra màn hình
            System.out.println("\n--> Đọc lại từ file " + filePath + ":");
            String readContent = IOManager.readFile(filePath);
            System.out.println(readContent);

        } catch (Exception e) {
            System.err.println("Có lỗi xảy ra: " + e.getMessage());
        }
    }
}
