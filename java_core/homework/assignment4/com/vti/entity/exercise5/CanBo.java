package java_core.homework.assignment4.com.vti.entity.exercise5;

public class CanBo {
    private String hoTen;
    private int tuoi;
    private String gioTinh; // "Nam", "Nữ", "Khác"
    private String diaChi;

    public CanBo(String hoTen, int tuoi, String gioTinh, String diaChi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioTinh = gioTinh;
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioTinh() {
        return gioTinh;
    }

    public void setGioTinh(String gioTinh) {
        this.gioTinh = gioTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Họ tên: " + hoTen + ", Tuổi: " + tuoi + ", Giới tính: " + gioTinh + ", Địa chỉ: " + diaChi;
    }
}