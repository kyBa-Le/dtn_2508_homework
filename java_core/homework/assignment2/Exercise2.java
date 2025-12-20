package java_core.homework.assignment2;

import java_core.homework.assignment1.Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java_core.homework.assignment2.Program2.accounts;

public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("\n=== Exercise 2: printf ===");

        int int5 = 5;
        System.out.printf("Question 1: %d%n", int5);

        int bigNum = 100000000;
        System.out.printf("Question 2: %,d%n", bigNum);

        double floatNum = 5.567098;
        System.out.printf("Question 3: %.4f%n", floatNum);

        String fullName = "Nguyễn Văn A";
        System.out.printf("Question 4: Tên tôi là \"%s\" và tôi đang độc thân.%n", fullName);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Question 5: " + dtf.format(LocalDateTime.now()));

        // Question 6: Table format
        System.out.println("\nQuestion 6: Account Table");
        System.out.printf("%-5s %-30s %-20s %-15s%n", "ID", "Email", "Full Name", "Department");
        System.out.println("---------------------------------------------------------------");
        for (Account a : accounts) {
            if (a != null) {
                String dept = a.getDepartment() == null ? "N/A" : a.getDepartment().getDepartmentName();
                System.out.printf("%-5d %-30s %-20s %-15s%n",
                        a.getAccountId(), a.getEmail(), a.getFullName(), dept);
            }
        }
    }
}
