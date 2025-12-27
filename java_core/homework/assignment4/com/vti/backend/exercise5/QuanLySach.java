package java_core.homework.assignment4.com.vti.backend.exercise5;

import java_core.homework.assignment4.com.vti.entity.exercise5.Bao;
import java_core.homework.assignment4.com.vti.entity.exercise5.Sach;
import java_core.homework.assignment4.com.vti.entity.exercise5.TaiLieu;
import java_core.homework.assignment4.com.vti.entity.exercise5.TapChi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach {
    private ArrayList<TaiLieu> danhSach;
    private Scanner scanner;

    public QuanLySach() {
        danhSach = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void themMoi() {
        System.out.println("Thêm: 1.Sách | 2.Tạp chí | 3.Báo");
        int loai = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Mã tài liệu: ");
        String ma = scanner.nextLine();
        System.out.print("Tên NXB: ");
        String nxb = scanner.nextLine();
        System.out.print("Số bản phát hành: ");
        int soBan = scanner.nextInt();
        scanner.nextLine();

        TaiLieu tl;
        switch (loai) {
            case 1:
                System.out.print("Tên tác giả: ");
                String tacGia = scanner.nextLine();
                System.out.print("Số trang: ");
                int soTrang = scanner.nextInt();
                tl = new Sach(ma, nxb, soBan, tacGia, soTrang);
                break;
            case 2:
                System.out.print("Số phát hành: ");
                int soPH = scanner.nextInt();
                System.out.print("Tháng phát hành: ");
                int thang = scanner.nextInt();
                tl = new TapChi(ma, nxb, soBan, soPH, thang);
                break;
            case 3:
                System.out.print("Ngày phát hành (yyyy-mm-dd): ");
                String dateStr = scanner.nextLine();
                LocalDate ngay = LocalDate.parse(dateStr);
                tl = new Bao(ma, nxb, soBan, ngay);
                break;
            default:
                System.out.println("Không hợp lệ!");
                return;
        }
        danhSach.add(tl);
        System.out.println("Thêm thành công!");
    }

    public void xoaTheoMa() {
        System.out.print("Nhập mã tài liệu cần xóa: ");
        String ma = scanner.nextLine();
        boolean removed = danhSach.removeIf(tl -> tl.getMaTaiLieu().equals(ma));
        System.out.println(removed ? "Xóa thành công!" : "Không tìm thấy!");
    }

    public void hienThi() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (TaiLieu tl : danhSach) {
            System.out.println(tl);
        }
    }

    public void timKiemTheoLoai() {
        System.out.println("Tìm theo: 1.Sách | 2.Tạp chí | 3.Báo");
        int loai = scanner.nextInt();
        for (TaiLieu tl : danhSach) {
            if ((loai == 1 && tl instanceof Sach) ||
                    (loai == 2 && tl instanceof TapChi) ||
                    (loai == 3 && tl instanceof Bao)) {
                System.out.println(tl);
            }
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n=== QUẢN LÝ THƯ VIỆN ===");
            System.out.println("1. Thêm mới tài liệu");
            System.out.println("2. Xóa theo mã tài liệu");
            System.out.println("3. Hiển thị danh sách");
            System.out.println("4. Tìm kiếm theo loại");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1 -> themMoi();
                case 2 -> xoaTheoMa();
                case 3 -> hienThi();
                case 4 -> timKiemTheoLoai();
                case 5 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
            }
        }
    }
}
