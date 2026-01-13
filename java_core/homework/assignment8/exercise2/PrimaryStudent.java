package java_core.homework.assignment8.exercise2;

/**
 * Exercise 2: Final
 * [cite_start]Question 4: Final class - không thể bị kế thừa [cite: 27]
 */
public final class PrimaryStudent extends Student {

    public PrimaryStudent(int id, String name) {
        super(id, name);
    }

    // Không thể Override method study() ở đây vì nó là final ở class cha.
    // Nếu cố tình viết lại sẽ báo lỗi biên dịch.
}
