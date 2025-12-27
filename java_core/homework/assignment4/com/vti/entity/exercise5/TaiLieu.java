package java_core.homework.assignment4.com.vti.entity.exercise5;

public abstract class TaiLieu {
    private String maTaiLieu;
    private String tenNXB;
    private int soBanPhatHanh;

    public TaiLieu(String maTaiLieu, String tenNXB, int soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.tenNXB = tenNXB;
        this.soBanPhatHanh = soBanPhatHanh;
    }

    // getters
    public String getMaTaiLieu() { return maTaiLieu; }
    public String getTenNXB() { return tenNXB; }
    public int getSoBanPhatHanh() { return soBanPhatHanh; }

    @Override
    public String toString() {
        return "Mã: " + maTaiLieu + ", NXB: " + tenNXB + ", Số bản: " + soBanPhatHanh;
    }
}