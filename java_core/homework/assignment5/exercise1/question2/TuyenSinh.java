package java_core.homework.assignment5.exercise1.question2;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh {
    private ArrayList<ThiSinh> danhSachThiSinh;
    private Scanner scanner;

    public TuyenSinh() {
        danhSachThiSinh = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    @Override
    public void themThiSinh() {
        System.out.println("Chọn khối thi: 1. Khối A | 2. Khối B | 3. Khối C");
        int khoi = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        System.out.print("Số báo danh: ");
        String soBaoDanh = scanner.nextLine();
        System.out.print("Họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String diaChi = scanner.nextLine();
        System.out.print("Mức ưu tiên: ");
        int mucUuTien = scanner.nextInt();
        scanner.nextLine();

        ThiSinh ts;
        switch (khoi) {
            case 1 -> ts = new KhoiA(soBaoDanh, hoTen, diaChi, mucUuTien);
            case 2 -> ts = new KhoiB(soBaoDanh, hoTen, diaChi, mucUuTien);
            case 3 -> ts = new KhoiC(soBaoDanh, hoTen, diaChi, mucUuTien);
            default -> {
                System.out.println("Khối không hợp lệ!");
                return;
            }
        }
        danhSachThiSinh.add(ts);
        System.out.println("Thêm thí sinh thành công!");
    }

    @Override
    public void hienThiThongTin() {
        if (danhSachThiSinh.isEmpty()) {
            System.out.println("Danh sách thí sinh trống.");
            return;
        }
        System.out.println("\n=== Danh sách thí sinh ===");
        for (ThiSinh ts : danhSachThiSinh) {
            System.out.println(ts);
        }
    }

    @Override
    public void timKiemTheoSoBaoDanh() {
        System.out.print("Nhập số báo danh cần tìm: ");
        String soBaoDanh = scanner.nextLine();
        boolean found = false;
        for (ThiSinh ts : danhSachThiSinh) {
            if (ts.getSoBaoDanh().equalsIgnoreCase(soBaoDanh)) {
                System.out.println("Tìm thấy:");
                System.out.println(ts);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy thí sinh có số báo danh: " + soBaoDanh);
        }
    }

    // Menu chính
    public void menu() {
        while (true) {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ TUYỂN SINH ===");
            System.out.println("1. Thêm mới thí sinh");
            System.out.println("2. Hiển thị thông tin thí sinh và khối thi");
            System.out.println("3. Tìm kiếm theo số báo danh");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> themThiSinh();
                case 2 -> hienThiThongTin();
                case 3 -> timKiemTheoSoBaoDanh();
                case 4 -> {
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
