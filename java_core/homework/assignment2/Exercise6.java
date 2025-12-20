package java_core.homework.assignment2;

import java_core.homework.assignment1.*;

public class Exercise6 {

    public static void main(String[] args) {
        System.out.println("=== Exercise 6: Method ===\n");

        // Question 1: In ra các số chẵn nguyên dương nhỏ hơn 10
        printEvenNumbersUnder10();
        System.out.println();

        // Question 2: In thông tin các account
        printAccounts();
        System.out.println();

        // Question 3: In ra các số nguyên dương nhỏ hơn 10
        printPositiveNumbersUnder10();
    }

    // Question 1: Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
    private static void printEvenNumbersUnder10() {
        System.out.println("Question 1: Các số chẵn nguyên dương nhỏ hơn 10:");
        for (int i = 2; i < 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println(); // xuống dòng cuối
    }

    // Question 2: Tạo method để in thông tin các account
    private static void printAccounts() {
        System.out.println("Question 2: Thông tin các Account:");
        System.out.printf("%-5s %-30s %-20s %-15s%n", "ID", "Email", "Full Name", "Department");
        System.out.println("-----------------------------------------------------------------");

        for (Account acc : Program2.accounts) {
            if (acc != null) {
                String deptName = (acc.getDepartment() == null) ? "Chưa có phòng ban"
                        : acc.getDepartment().getDepartmentName();
                System.out.printf("%-5d %-30s %-20s %-15s%n",
                        acc.getAccountId(),
                        acc.getEmail(),
                        acc.getFullName(),
                        deptName);
            }
        }
    }

    // Question 3: Tạo method để in ra các số nguyên dương nhỏ hơn 10
    private static void printPositiveNumbersUnder10() {
        System.out.println("Question 3: Các số nguyên dương nhỏ hơn 10:");
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // xuống dòng cuối
    }
}