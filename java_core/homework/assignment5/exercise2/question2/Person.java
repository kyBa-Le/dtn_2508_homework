package java_core.homework.assignment5.exercise2.question2;

import java.util.Scanner;

public class Person {
    private String ten;
    private String gioTinh;
    private String ngaySinh;  // định dạng dd/MM/yyyy
    private String diaChi;

    public Person() {
    }

    public Person(String ten, String gioTinh, String ngaySinh, String diaChi) {
        this.ten = ten;
        this.gioTinh = gioTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    // Getters và Setters
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioTinh() {
        return gioTinh;
    }

    public void setGioTinh(String gioTinh) {
        this.gioTinh = gioTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên: ");
        ten = scanner.nextLine();

        System.out.print("Nhập giới tính: ");
        gioTinh = scanner.nextLine();

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        ngaySinh = scanner.nextLine();

        System.out.print("Nhập địa chỉ: ");
        diaChi = scanner.nextLine();
    }

    public void showInfo() {
        System.out.println("Tên: " + ten);
        System.out.println("Giới tính: " + gioTinh);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Địa chỉ: " + diaChi);
    }
}