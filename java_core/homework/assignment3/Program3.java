package java_core.homework.assignment3;

import java_core.homework.assignment1.Account;
import java_core.homework.assignment1.Department;
import java_core.homework.assignment1.Group;
import java_core.homework.assignment2.Program2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== Exercise 1: Datatype Casting ===");

        // Question 1
        float salary1 = 5240.5f;
        float salary2 = 10970.055f;

        int roundedSalary1 = Math.round(salary1);
        int roundedSalary2 = Math.round(salary2);

        System.out.println("Lương Account 1 làm tròn: " + roundedSalary1);
        System.out.println("Lương Account 2 làm tròn: " + roundedSalary2);

        // Question 2
        int fiveDigitNumber = random.nextInt(90000) + 10000; // từ 10000 đến 99999
        System.out.println("Số ngẫu nhiên 5 chữ số: " + fiveDigitNumber);

        // Question 3
        // Cách 1: convert sang String
        String numStr = String.format("%05d", fiveDigitNumber);
        String lastTwoStr = numStr.substring(numStr.length() - 2);
        System.out.println("2 số cuối (cách String): " + lastTwoStr);

        // Cách 2: toán tử %
        int lastTwoInt = fiveDigitNumber % 100;
        System.out.println("2 số cuối (cách %): " + lastTwoInt);

        // Question 4
        System.out.println("Thương 15 / 4 = " + divide(15, 4));
        System.out.println("Thương 20 / 3 = " + divide(20, 3));

        System.out.println("\n=== Exercise 2: Default value ===");

        // Question 1
        Account[] newAccounts = new Account[5];
        for (int i = 0; i < newAccounts.length; i++) {
            newAccounts[i] = new Account();
            newAccounts[i].setEmail("Email " + (i + 1));
            newAccounts[i].setUsername("User name " + (i + 1));
            newAccounts[i].setFullName("Full name " + (i + 1));
            newAccounts[i].setCreateDate(java.sql.Date.valueOf(LocalDate.now()));
        }

        System.out.println("Đã khởi tạo 5 Account mới với giá trị mặc định.");

        System.out.println("\n=== Exercise 3: Boxing & Unboxing ===");

        // Question 1
        Integer salaryInteger = 5000;
        float salaryFloat = salaryInteger.floatValue();
        System.out.printf("Lương float (2 chữ số thập phân): %.2f%n", salaryFloat);

        // Question 2
        String strNumber = "1234567";
        int intFromString = Integer.parseInt(strNumber);
        System.out.println("Convert String sang int: " + intFromString);

        // Question 3
        Integer wrapperInteger = Integer.valueOf("1234567");
        int primitiveInt = wrapperInteger; // unboxing
        System.out.println("Convert Integer sang int: " + primitiveInt);

        System.out.println("\n=== Exercise 4: String ===");

        // Question 1
        System.out.print("Nhập một xâu ký tự: ");
        scanner.nextLine(); // clear buffer nếu cần
        String inputString = scanner.nextLine();
        int wordCount = inputString.trim().split("\\s+").length;
        System.out.println("Số lượng từ: " + wordCount);

        // Question 2
        System.out.print("Nhập xâu s1: ");
        String s1 = scanner.nextLine();
        System.out.print("Nhập xâu s2: ");
        String s2 = scanner.nextLine();
        System.out.println("Chuỗi nối: " + s1 + s2);

        // Question 3
        System.out.print("Nhập tên: ");
        String nameInput = scanner.nextLine().trim();
        if (!nameInput.isEmpty()) {
            String capitalizedName = nameInput.substring(0, 1).toUpperCase() + nameInput.substring(1).toLowerCase();
            System.out.println("Tên sau chuẩn hóa chữ cái đầu: " + capitalizedName);
        }

        // Question 4
        System.out.print("Nhập tên để in từng ký tự: ");
        String charName = scanner.nextLine();
        for (int i = 0; i < charName.length(); i++) {
            System.out.println("Ký tự thứ " + (i + 1) + " là: " + charName.charAt(i));
        }

        // Question 5
        System.out.print("Nhập họ: ");
        String ho = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String ten = scanner.nextLine();
        System.out.println("Họ và tên đầy đủ: " + ho.trim() + " " + ten.trim());

        // Question 6
        System.out.print("Nhập họ và tên đầy đủ: ");
        String fullName = scanner.nextLine().trim();
        String[] parts = fullName.split("\\s+");
        if (parts.length > 0) {
            System.out.println("Họ là: " + parts[0]);
            if (parts.length >= 3) {
                System.out.println("Tên đệm là: " + parts[1]);
                System.out.println("Tên là: " + parts[parts.length - 1]);
            } else if (parts.length == 2) {
                System.out.println("Tên là: " + parts[1]);
            }
        }

        // Question 7
        System.out.print("Nhập họ và tên để chuẩn hóa: ");
        String rawFullName = scanner.nextLine();
        String cleaned = rawFullName.trim().replaceAll("\\s+", " ");
        String[] nameParts = cleaned.split(" ");
        StringBuilder standardized = new StringBuilder();
        for (String part : nameParts) {
            if (!part.isEmpty()) {
                standardized.append(part.substring(0, 1).toUpperCase())
                        .append(part.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        System.out.println("Tên chuẩn hóa: " + standardized.toString().trim());

        // Question 8
        System.out.println("\nCác group chứa chữ \"Java\":");
        for (Group g : Program2.groups) {
            if (g != null && g.getGroupName().contains("Java")) {
                System.out.println(g.getGroupName());
            }
        }

        // Question 9
        System.out.println("\nCác group có tên đúng \"Java\":");
        for (Group g : Program2.groups) {
            if (g != null && g.getGroupName().equals("Java")) {
                System.out.println(g.getGroupName());
            }
        }

        // Question 10
        System.out.print("Nhập chuỗi thứ nhất: ");
        String str1 = scanner.nextLine();
        System.out.print("Nhập chuỗi thứ hai: ");
        String str2 = scanner.nextLine();
        String reversedStr1 = new StringBuilder(str1).reverse().toString();
        System.out.println(str1.equals(reversedStr1) ? "OK" : "KO");

        // Question 11
        System.out.print("Nhập chuỗi để đếm ký tự 'a': ");
        String countAString = scanner.nextLine();
        int countA = 0;
        for (char c : countAString.toCharArray()) {
            if (c == 'a' || c == 'A') countA++;
        }
        System.out.println("Số lần xuất hiện 'a' hoặc 'A': " + countA);

        // Question 12
        System.out.print("Nhập chuỗi để đảo ngược: ");
        String reverseInput = scanner.nextLine();
        StringBuilder reversed = new StringBuilder();
        for (int i = reverseInput.length() - 1; i >= 0; i--) {
            reversed.append(reverseInput.charAt(i));
        }
        System.out.println("Chuỗi đảo ngược: " + reversed);

        // Question 13
        System.out.print("Nhập chuỗi kiểm tra có chữ số không: ");
        String digitInput = scanner.nextLine();
        boolean noDigit = true;
        if (digitInput != null) {
            for (char c : digitInput.toCharArray()) {
                if (Character.isDigit(c)) {
                    noDigit = false;
                    break;
                }
            }
        }
        System.out.println(noDigit);

        // Question 14
        String academyStr = "VTI Academy";
        String replacedStr = academyStr.replace('e', '*');
        System.out.println("Thay 'e' thành '*': " + replacedStr);

        // Question 15
        System.out.print("Nhập câu để đảo ngược từ: ");
        String sentenceInput = scanner.nextLine();
        String[] words = sentenceInput.trim().split("\\s+");
        StringBuilder revertedWords = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            revertedWords.append(words[i]).append(" ");
        }
        System.out.println("Câu đảo ngược từ: " + revertedWords.toString().trim());

        // Question 16
        System.out.print("Nhập chuỗi str: ");
        String splitStr = scanner.nextLine();
        System.out.print("Nhập số n (>=0): ");
        int n = scanner.nextInt();
        scanner.nextLine();
        if (n <= 0 || splitStr.length() % n != 0) {
            System.out.println("KO");
        } else {
            for (int i = 0; i < splitStr.length(); i += n) {
                System.out.println(splitStr.substring(i, i + n));
            }
        }

        System.out.println("\n=== Exercise 5: Object’s Method ===");

        // Question 1
        System.out.println("Thông tin phòng ban thứ 1:");
        System.out.println(Program2.departments[0]);

        // Question 2
        System.out.println("\nThông tin tất cả phòng ban:");
        for (Department d : Program2.departments) {
            if (d != null) {
                System.out.println(d);
            }
        }

        // Question 3
        System.out.println("\nĐịa chỉ bộ nhớ phòng ban thứ 1: " + System.identityHashCode(Program2.departments[0]));

        // Question 4
        boolean isPhongA = Program2.departments[0].getDepartmentName().equals("Phòng A");
        System.out.println("Phòng ban thứ 1 có tên \"Phòng A\" không? " + isPhongA);

        // Question 5
        boolean sameName = Program2.departments[0].getDepartmentName()
                .equals(Program2.departments[1].getDepartmentName());
        System.out.println("Phòng ban 1 và 2 có tên giống nhau không? " + sameName);

        // Question 6 & 7
        Department[] sortDepts = new Department[5];
        sortDepts[0] = new Department(1, "Marketing");
        sortDepts[1] = new Department(2, "Accounting");
        sortDepts[2] = new Department(3, "Waiting room");
        sortDepts[3] = new Department(4, "Sale");
        sortDepts[4] = new Department(5, "Boss of director");

        Arrays.sort(sortDepts, (d1, d2) -> {
            if (d1 == null) return 1;
            if (d2 == null) return -1;
            return d1.getDepartmentName().compareToIgnoreCase(d2.getDepartmentName());
        });

        System.out.println("\nDanh sách phòng ban sắp xếp theo tên (A-Z):");
        for (Department d : sortDepts) {
            if (d != null) {
                System.out.println(d.getDepartmentName());
            }
        }

        scanner.close();
    }

    // Question 4 - Exercise 1
    private static float divide(int a, int b) {
        if (b == 0) {
            System.out.println("Không thể chia cho 0!");
            return 0;
        }
        return (float) a / b;
    }
}