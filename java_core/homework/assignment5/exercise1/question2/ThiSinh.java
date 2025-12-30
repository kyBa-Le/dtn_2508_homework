package java_core.homework.assignment5.exercise1.question2;

public abstract class ThiSinh {
    private String soBaoDanh;
    private String hoTen;
    private String diaChi;
    private int mucUuTien;

    public ThiSinh(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        this.soBaoDanh = soBaoDanh;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.mucUuTien = mucUuTien;
    }

    // Getters
    public String getSoBaoDanh() {
        return soBaoDanh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getMucUuTien() {
        return mucUuTien;
    }

    public abstract String getKhoiThi();

    @Override
    public String toString() {
        return "Số báo danh: " + soBaoDanh +
                ", Họ tên: " + hoTen +
                ", Địa chỉ: " + diaChi +
                ", Mức ưu tiên: " + mucUuTien +
                ", Khối thi: " + getKhoiThi();
    }
}
