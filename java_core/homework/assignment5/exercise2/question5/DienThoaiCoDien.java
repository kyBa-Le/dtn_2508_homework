package java_core.homework.assignment5.exercise2.question5;

public class DienThoaiCoDien extends DienThoaiDiDong {
    @Override
    public void nghe() {
        System.out.println("Nghe cuộc gọi qua loa ngoài");
    }

    @Override
    public void goi() {
        System.out.println("Gọi điện bằng phím bấm vật lý");
    }

    @Override
    public void guiTinNhan() {
        System.out.println("Gửi tin nhắn SMS bằng phím T9");
    }

    @Override
    public void nhanTinNhan() {
        System.out.println("Nhận tin nhắn SMS với tiếng beep beep");
    }

    public void ngheRadio() {
        System.out.println("Nghe đài FM 101.5 MHz");
    }
}