package java_core.homework.assignment8.advanced_static;

public class HinhChuNhat extends HinhHoc {
    private float chieuDai;
    private float chieuRong;

    public HinhChuNhat(float chieuDai, float chieuRong) throws HinhHocException {
        super();
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    @Override
    public float tinhChuVi() {
        return (chieuDai + chieuRong) * 2;
    }

    @Override
    public float tinhDienTich() {
        return chieuDai * chieuRong;
    }
}
