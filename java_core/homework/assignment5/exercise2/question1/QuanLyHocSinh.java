package java_core.homework.assignment5.exercise2.question1;

import java.util.ArrayList;

public class QuanLyHocSinh {
    private ArrayList<Student> danhSachHocSinh;

    public QuanLyHocSinh() {
        danhSachHocSinh = new ArrayList<>();
    }

    // a) Tạo 10 học sinh và chia thành 3 nhóm
    public void taoDanhSachHocSinh() {
        // Nhóm 1: 4 học sinh
        danhSachHocSinh.add(new Student(1, "Nguyễn Văn A1", 1));
        danhSachHocSinh.add(new Student(2, "Nguyễn Văn A2", 1));
        danhSachHocSinh.add(new Student(3, "Nguyễn Văn A3", 1));
        danhSachHocSinh.add(new Student(4, "Nguyễn Văn A4", 1));

        // Nhóm 2: 3 học sinh
        danhSachHocSinh.add(new Student(5, "Trần Thị B1", 2));
        danhSachHocSinh.add(new Student(6, "Trần Thị B2", 2));
        danhSachHocSinh.add(new Student(7, "Trần Thị B3", 2));

        // Nhóm 3: 3 học sinh
        danhSachHocSinh.add(new Student(8, "Lê Văn C1", 3));
        danhSachHocSinh.add(new Student(9, "Lê Văn C2", 3));
        danhSachHocSinh.add(new Student(10, "Lê Văn C3", 3));

        System.out.println("Đã tạo 10 học sinh và chia thành 3 nhóm.");
    }

    // b) Cả lớp điểm danh
    public void caLopDiemDanh() {
        System.out.println("\n=== Cả lớp điểm danh ===");
        for (Student hs : danhSachHocSinh) {
            hs.diemDanh();
        }
    }

    // c) Nhóm 1 đi học bài
    public void nhom1HocBai() {
        System.out.println("\n=== Nhóm 1 đi học bài ===");
        for (Student hs : danhSachHocSinh) {
            if (hs.getGroup() == 1) {
                hs.hocBai();
            }
        }
    }

    // d) Nhóm 2 đi dọn vệ sinh
    public void nhom2DonVeSinh() {
        System.out.println("\n=== Nhóm 2 đi dọn vệ sinh ===");
        for (Student hs : danhSachHocSinh) {
            if (hs.getGroup() == 2) {
                hs.diDonVeSinh();
            }
        }
    }
}