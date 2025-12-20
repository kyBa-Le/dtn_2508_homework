package java_core.homework.assignment2;

import java_core.homework.assignment1.Exam;

import java.text.SimpleDateFormat;
import java.util.Locale;

import static java_core.homework.assignment2.Program2.accounts;

public class Exercise3 {
    public static void main(String[] args) {
        System.out.println("\n=== Exercise 3: Date Format ===");
        Exam exam1 = new Exam(1, "EX001", "Java Exam", null, 60, accounts[0], java.sql.Date.valueOf("2023-04-24"));

        SimpleDateFormat vietnameseFormat = new SimpleDateFormat("EEEE, 'ngày' dd 'tháng' MM 'năm' yyyy", new Locale("vi", "VN"));
        System.out.println("Question 1: " + vietnameseFormat.format(exam1.getCreateDate()));

        SimpleDateFormat fullFormat = new SimpleDateFormat("yyyy - MM - dd - HH - mm - ss");
        System.out.println("Question 2: " + fullFormat.format(exam1.getCreateDate()));

        SimpleDateFormat yearOnly = new SimpleDateFormat("yyyy");
        System.out.println("Question 3: " + yearOnly.format(exam1.getCreateDate()));

        SimpleDateFormat monthYear = new SimpleDateFormat("MM-yyyy");
        System.out.println("Question 4: " + monthYear.format(exam1.getCreateDate()));

        SimpleDateFormat mmdd = new SimpleDateFormat("MM-dd");
        System.out.println("Question 5: " + mmdd.format(exam1.getCreateDate()));
    }
}
