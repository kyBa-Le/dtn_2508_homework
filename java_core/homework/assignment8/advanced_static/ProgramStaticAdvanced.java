package java_core.homework.assignment8.advanced_static;

public class ProgramStaticAdvanced {
    public static void main(String[] args) {
        System.out.println("--- EXERCISE 1 (Q8): LIMIT HINH HOC ---");
        try {
            // Tạo 5 hình đầu tiên (Thành công)
            System.out.println("Tạo hình 1...");
            new HinhTron(1.0f);

            System.out.println("Tạo hình 2...");
            new HinhChuNhat(2f, 3f);

            System.out.println("Tạo hình 3...");
            new HinhTron(4.0f);

            System.out.println("Tạo hình 4...");
            new HinhChuNhat(5f, 6f);

            System.out.println("Tạo hình 5...");
            new HinhTron(7.0f);

            System.out.println("Hiện tại đã tạo: " + HinhHoc.getCount() + " hình.");

            // Tạo hình thứ 6 (Sẽ lỗi Exception)
            System.out.println("Cố tình tạo hình thứ 6...");
            new HinhTron(10.0f);

        } catch (HinhHocException e) {
            System.err.println("LỖI: " + e.getMessage());
        }
    }
}
