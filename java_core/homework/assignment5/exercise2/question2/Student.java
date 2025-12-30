package java_core.homework.assignment5.exercise2.question2;

import java.util.Scanner;

public class Student extends Person {
    private String maSinhVien;
    private double diemTrungBinh;
    private String email;

    public Student() {
        super();
    }

    public Student(String ten, String gioTinh, String ngaySinh, String diaChi,
                   String maSinhVien, double diemTrungBinh, String email) {
        super(ten, gioTinh, ngaySinh, diaChi);
        this.maSinhVien = maSinhVien;
        this.diemTrungBinh = diemTrungBinh;
        this.email = email;
    }

    // Getters và Setters
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void inputInfo() {
        super.inputInfo();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sinh viên: ");
        maSinhVien = scanner.nextLine();

        System.out.print("Nhập điểm trung bình: ");
        diemTrungBinh = scanner.nextDouble();
        scanner.nextLine(); // clear buffer

        System.out.print("Nhập email: ");
        email = scanner.nextLine();
    }

    @Override
    public void showInfo() {
        super.showInfo(); // hiển thị thông tin từ lớp cha
        System.out.println("Mã sinh viên: " + maSinhVien);
        System.out.println("Điểm trung bình: " + diemTrungBinh);
        System.out.println("Email: " + email);
    }

    public boolean coHocBong() {
        return diemTrungBinh >= 8.0;
    }
}