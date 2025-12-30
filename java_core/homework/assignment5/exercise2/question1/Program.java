package java_core.homework.assignment5.exercise2.question1;

public class Program {
    public static void main(String[] args) {
        QuanLyHocSinh ql = new QuanLyHocSinh();

        // a) Tạo 10 học sinh, chia thành 3 nhóm
        ql.taoDanhSachHocSinh();

        // b) Kêu gọi cả lớp điểm danh
        ql.caLopDiemDanh();

        // c) Gọi nhóm 1 đi học bài
        ql.nhom1HocBai();

        // d) Gọi nhóm 2 đi dọn vệ sinh
        ql.nhom2DonVeSinh();
    }
}