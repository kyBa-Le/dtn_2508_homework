package java_core.homework.assignment4.com.vti.entity.exercise5;

public class Sach extends TaiLieu {
    private String tenTacGia;
    private int soTrang;

    public Sach(String maTaiLieu, String tenNXB, int soBanPhatHanh, String tenTacGia, int soTrang) {
        super(maTaiLieu, tenNXB, soBanPhatHanh);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    @Override
    public String toString() {
        return "[Sách] " + super.toString() + ", Tác giả: " + tenTacGia + ", Số trang: " + soTrang;
    }
}