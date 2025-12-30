package java_core.homework.assignment5.exercise1.question2;

public class KhoiA extends ThiSinh {
    private static final String KHOI = "A (Toán, Lý, Hóa)";

    public KhoiA(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public String getKhoiThi() {
        return KHOI;
    }
}