package java_core.homework.assignment8.exercise1;

/**
 * Exercise 1: Static
 * [cite_start]Question 1: Static variable (college) [cite: 7]
 * [cite_start]Question 2: MoneyGroup logic [cite: 9]
 * [cite_start]Question 4: Static method getter/setter for college [cite: 14]
 * [cite_start]Question 5: Student counter [cite: 15]
 */
public class Student {
    // Thuộc tính instance (riêng từng đối tượng)
    private int id;
    private String name;

    // Thuộc tính static (dùng chung cho cả lớp)
    // Q1: College chung cho tất cả sinh viên
    private static String college = "Đại học bách khoa";

    // Q2: Quỹ lớp dùng chung (moneyGroup)
    private static int moneyGroup = 0;

    // Q5: Biến đếm số lượng sinh viên được tạo
    public static int count = 0;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        // Q5: Mỗi khi tạo mới 1 sinh viên, tăng biến đếm
        count++;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Q4: Method static để lấy giá trị college
    public static String getCollege() {
        return college;
    }

    // Q4: Method static để thay đổi college
    public static void setCollege(String newCollege) {
        college = newCollege;
    }

    // --- Các method hỗ trợ quản lý quỹ lớp (Q2) ---
    public static int getMoneyGroup() {
        return moneyGroup;
    }

    // Nộp quỹ (tăng tiền)
    public static void nopQuy(int amount) {
        moneyGroup += amount;
        System.out.println("Nhóm nộp thêm: " + amount + "k. Tổng quỹ: " + moneyGroup + "k");
    }

    // Rút quỹ (giảm tiền)
    public static void rutQuy(int amount, String reason) {
        moneyGroup -= amount;
        System.out.println("Rút " + amount + "k để " + reason + ". Tổng quỹ còn: " + moneyGroup + "k");
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", college=" + college + "]";
    }
}
