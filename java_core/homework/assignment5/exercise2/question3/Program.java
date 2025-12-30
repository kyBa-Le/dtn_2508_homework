package java_core.homework.assignment5.exercise2.question3;

public class Program {
    public static void main(String[] args) {
        System.out.println("=== Demo Hình Chữ Nhật ===");
        HinhChuNhat hcn = new HinhChuNhat(10, 5);
        System.out.println("Chu vi HCN: " + hcn.tinhChuVi());
        System.out.println("Diện tích HCN: " + hcn.tinhDienTich());
        System.out.println();

        System.out.println("=== Demo Hình Vuông ===");
        HinhVuong hv = new HinhVuong(6);
        System.out.println("Chu vi HV: " + hv.tinhChuVi());
        System.out.println("Diện tích HV: " + hv.tinhDienTich());
    }
}