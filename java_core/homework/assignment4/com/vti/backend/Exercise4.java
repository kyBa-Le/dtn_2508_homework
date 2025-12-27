package java_core.homework.assignment4.com.vti.backend;

import java_core.homework.assignment4.com.vti.entity.exercise4.Student;

public class Exercise4 {
    public static void main(String[] args) {
        Student sv1 = new Student("Nguyễn Văn An", "Hà Nội");
        Student sv2 = new Student("Trần Thị Bình", "TP. Hồ Chí Minh");
        sv1.setId(1);
        sv2.setId(2);

        sv1.setDiemHocLuc(7.5);
        sv2.setDiemHocLuc(3.8);

        sv1.congDiem(1.0);
        sv2.congDiem(2.5);

        System.out.println("Thông tin sinh viên 1:");
        sv1.inThongTin();
        System.out.println();

        System.out.println("Thông tin sinh viên 2:");
        sv2.inThongTin();
    }
}
