package java_core.homework.assignment5.exercise1.question1;

import java.util.ArrayList;
import java.util.Scanner;

public class MyNews {
    private static final ArrayList<News> newsList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n================== MENU ==================");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Chọn chức năng (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    insertNews();
                    break;
                case 2:
                    viewListNews();
                    break;
                case 3:
                    averageRate();
                    break;
                case 4:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    // Chức năng 1: Insert news
    private static void insertNews() {
        System.out.println("\n--- Thêm tin tức mới ---");
        News news = new News();

        System.out.print("Nhập Title: ");
        news.setTitle(scanner.nextLine());

        System.out.print("Nhập Publish Date: ");
        news.setPublishDate(scanner.nextLine());

        System.out.print("Nhập Author: ");
        news.setAuthor(scanner.nextLine());

        System.out.print("Nhập Content: ");
        news.setContent(scanner.nextLine());

        System.out.println("Nhập 3 đánh giá (1-10):");
        System.out.print("Đánh giá 1: ");
        int rate1 = scanner.nextInt();
        System.out.print("Đánh giá 2: ");
        int rate2 = scanner.nextInt();
        System.out.print("Đánh giá 3: ");
        int rate3 = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        news.setRates(rate1, rate2, rate3);

        newsList.add(news);
        System.out.println("Thêm tin tức thành công!");
    }

    // Chức năng 2: View list news
    private static void viewListNews() {
        if (newsList.isEmpty()) {
            System.out.println("\nDanh sách tin tức trống.");
            return;
        }

        System.out.println("\n--- Danh sách tin tức ---");
        for (News news : newsList) {
            news.Display();
            System.out.println("-------------------------");
        }
    }

    // Chức năng 3: Average rate → Calculate() + Display()
    private static void averageRate() {
        if (newsList.isEmpty()) {
            System.out.println("\nDanh sách tin tức trống.");
            return;
        }

        System.out.println("\n--- Tính điểm trung bình và hiển thị ---");
        for (News news : newsList) {
            news.Calculate();   // Tính AverageRate
            news.Display();     // Hiển thị thông tin kèm AverageRate
            System.out.println("-------------------------");
        }
    }
}