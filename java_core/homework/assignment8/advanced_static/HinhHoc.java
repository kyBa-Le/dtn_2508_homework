package java_core.homework.assignment8.advanced_static;

public abstract class HinhHoc {
    // Biến static đếm tổng số hình đã tạo
    private static int count = 0;

    public HinhHoc() throws HinhHocException {
        // Kiểm tra trước khi tạo
        if (count >= Configs.SO_LUONG_HINH_TOI_DA) {
            throw new HinhHocException();
        }
        count++; // Tăng biến đếm nếu chưa vượt quá
    }

    public static int getCount() {
        return count;
    }

    public abstract float tinhChuVi();

    public abstract float tinhDienTich();
}
