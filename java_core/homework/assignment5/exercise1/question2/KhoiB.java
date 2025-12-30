package java_core.homework.assignment5.exercise1.question2;

public class KhoiB extends ThiSinh {
    private static final String KHOI = "B (Toán, Hóa, Sinh)";

    public KhoiB(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public String getKhoiThi() {
        return KHOI;
    }
}
