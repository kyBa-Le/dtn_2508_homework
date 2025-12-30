package java_core.homework.assignment5.exercise1.question2;

public class KhoiC extends ThiSinh {
    private static final String KHOI = "C (Văn, Sử, Địa)";

    public KhoiC(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public String getKhoiThi() {
        return KHOI;
    }
}
