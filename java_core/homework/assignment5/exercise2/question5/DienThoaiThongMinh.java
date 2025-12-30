package java_core.homework.assignment5.exercise2.question5;

public class DienThoaiThongMinh extends DienThoaiDiDong {
    @Override
    public void nghe() {
        System.out.println("Nghe cuộc gọi qua tai nghe Bluetooth");
    }

    @Override
    public void goi() {
        System.out.println("Gọi điện qua danh bạ thông minh");
    }

    @Override
    public void guiTinNhan() {
        System.out.println("Gửi tin nhắn qua iMessage/Zalo");
    }

    @Override
    public void nhanTinNhan() {
        System.out.println("Nhận tin nhắn với thông báo thông minh");
    }

    public void suDung3G() {
        System.out.println("Đang lướt web bằng 3G");
    }

    public void chupHinh() {
        System.out.println("Chụp hình bằng camera 108MP");
    }
}