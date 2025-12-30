package java_core.homework.assignment5.exercise2.question3;

public class HinhVuong extends HinhChuNhat {

    public HinhVuong(double canh) {
        super(canh, canh); // gọi constructor của lớp cha với cả 2 cạnh bằng nhau
    }

    @Override
    public double tinhChuVi() {
        System.out.println("Tính chu vi theo Hình Vuông");
        return super.tinhChuVi(); // gọi method của lớp cha
    }

    @Override
    public double tinhDienTich() {
        System.out.println("Tính diện tích theo Hình Vuông");
        return super.tinhDienTich(); // gọi method của lớp cha
    }
}