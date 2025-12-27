package java_core.homework.assignment4.com.vti.entity.exercise5;

public class CongNhan extends CanBo {
    private int bac; // từ 1 đến 10

    public CongNhan(String hoTen, int tuoi, String gioTinh, String diaChi, int bac) {
        super(hoTen, tuoi, gioTinh, diaChi);
        this.bac = bac;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        if (bac >= 1 && bac <= 10) {
            this.bac = bac;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Bậc: " + bac + " (Công nhân)";
    }
}
