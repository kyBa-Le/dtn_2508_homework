package java_core.homework.assignment4.com.vti.entity.exercise5;


public class KySu extends CanBo {
    private String nganhDaoTao;

    public KySu(String hoTen, int tuoi, String gioTinh, String diaChi, String nganhDaoTao) {
        super(hoTen, tuoi, gioTinh, diaChi);
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public String toString() {
        return super.toString() + ", Ngành đào tạo: " + nganhDaoTao + " (Kỹ sư)";
    }
}
