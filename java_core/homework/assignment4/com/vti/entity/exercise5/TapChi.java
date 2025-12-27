package java_core.homework.assignment4.com.vti.entity.exercise5;

public class TapChi extends TaiLieu {
    private int soPhatHanh;
    private int thangPhatHanh;

    public TapChi(String maTaiLieu, String tenNXB, int soBanPhatHanh, int soPhatHanh, int thangPhatHanh) {
        super(maTaiLieu, tenNXB, soBanPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    @Override
    public String toString() {
        return "[Tạp chí] " + super.toString() + ", Số phát hành: " + soPhatHanh + ", Tháng: " + thangPhatHanh;
    }
}
