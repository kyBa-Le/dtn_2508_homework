package java_core.homework.assignment8.advanced_static;

public class HinhHocException extends Exception {
    public HinhHocException() {
        super("Số lượng hình tối đa là: " + Configs.SO_LUONG_HINH_TOI_DA);
    }

    public HinhHocException(String message) {
        super(message);
    }
}
