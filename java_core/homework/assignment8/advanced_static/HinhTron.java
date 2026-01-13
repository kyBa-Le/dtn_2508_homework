package java_core.homework.assignment8.advanced_static;

public class HinhTron extends HinhHoc {
    private float banKinh;

    public HinhTron(float banKinh) throws HinhHocException {
        super(); // Gọi constructor cha để check số lượng
        this.banKinh = banKinh;
    }

    @Override
    public float tinhChuVi() {
        return 2 * 3.14f * banKinh;
    }

    @Override
    public float tinhDienTich() {
        return 3.14f * banKinh * banKinh;
    }
}
