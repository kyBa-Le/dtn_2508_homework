package java_core.homework.assignment5.exercise2.question5;

public abstract class DienThoaiDiDong implements VuKhi {
    public abstract void nghe();
    public abstract void goi();
    public abstract void guiTinNhan();
    public abstract void nhanTinNhan();

    @Override
    public void tanCongKeXau() {
        System.out.println("Dùng điện thoại tấn công kẻ xấu! (Ném mạnh vào mặt)");
    }
}