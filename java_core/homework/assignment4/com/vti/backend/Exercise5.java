package java_core.homework.assignment4.com.vti.backend;

import java_core.homework.assignment4.com.vti.entity.exercise5.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise5 {
    private ArrayList<CanBo> danhSachCanBo;
    private Scanner scanner;

    public Exercise5() {
        danhSachCanBo = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void themMoiCanBo() {
        System.out.println("Chọn loại cán bộ: 1. Công nhân | 2. Kỹ sư | 3. Nhân viên");
        int loai = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Tuổi: ");
        int tuoi = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Giới tính (Nam/Nữ/Khác): ");
        String gioTinh = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String diaChi = scanner.nextLine();

        CanBo cb;
        switch (loai) {
            case 1:
                System.out.print("Bậc (1-10): ");
                int bac = scanner.nextInt();
                cb = new CongNhan(hoTen, tuoi, gioTinh, diaChi, bac);
                break;
            case 2:
                scanner.nextLine();
                System.out.print("Ngành đào tạo: ");
                String nganh = scanner.nextLine();
                cb = new KySu(hoTen, tuoi, gioTinh, diaChi, nganh);
                break;
            case 3:
                System.out.print("Công việc: ");
                String congViec = scanner.nextLine();
                cb = new NhanVien(hoTen, tuoi, gioTinh, diaChi, congViec);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }
        danhSachCanBo.add(cb);
        System.out.println("Thêm cán bộ thành công!");
    }

    public void timKiemTheoHoTen() {
        System.out.print("Nhập họ tên cần tìm: ");
        String ten = scanner.nextLine();
        boolean found = false;
        for (CanBo cb : danhSachCanBo) {
            if (cb.getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                System.out.println(cb);
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy cán bộ nào.");
    }

    public void hienThiDanhSach() {
        if (danhSachCanBo.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (CanBo cb : danhSachCanBo) {
            System.out.println(cb);
        }
    }

    public void xoaCanBo() {
        System.out.print("Nhập họ tên cán bộ cần xóa: ");
        String ten = scanner.nextLine();
        boolean removed = danhSachCanBo.removeIf(cb -> cb.getHoTen().equalsIgnoreCase(ten));
        if (removed) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tìm thấy cán bộ để xóa.");
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n=== QUẢN LÝ CÁN BỘ ===");
            System.out.println("1. Thêm mới cán bộ");
            System.out.println("2. Tìm kiếm theo họ tên");
            System.out.println("3. Hiển thị danh sách cán bộ");
            System.out.println("4. Xóa cán bộ theo tên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1 -> themMoiCanBo();
                case 2 -> timKiemTheoHoTen();
                case 3 -> hienThiDanhSach();
                case 4 -> xoaCanBo();
                case 5 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void main(String[] args) {
        HighSchoolStudent hs = new HighSchoolStudent(1, "Nam", "Chuyên Văn", "Đại học công nghệ");
        System.out.println(hs);
    }
}
