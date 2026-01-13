package java_core.homework.assignment8.exercise2;

/**
 * Exercise 2: Final
 * [cite_start]Question 2: Final variable (id) [cite: 24]
 * [cite_start]Question 3: Final method (study) [cite: 25]
 */
public class Student {
    // Q2: id là final, không thể thay đổi sau khi khởi tạo
    private final int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Q3: Final method - không thể bị Override bởi class con
    public final void study() {
        System.out.println("Đang học bài...");
    }
}
