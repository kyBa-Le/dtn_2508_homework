package java_core.homework.assignment8.exercise1;

/**
 * Exercise 1 - Question 3: Static method
 * [cite_start]Viết class MyMath thay thế class Math của Java [cite: 12]
 */
public class MyMath {

    // Trả về số nhỏ nhất trong 2 số
    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    // Trả về tổng 2 số
    public static int sum(int a, int b) {
        return a + b;
    }
}
