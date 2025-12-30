package java_core.homework.assignment5.exercise2.question5;

public class Program {
    public static void main(String[] args) {
        System.out.println("=== ĐIỆN THOẠI THÔNG MINH ===");
        DienThoaiThongMinh dtThongMinh = new DienThoaiThongMinh();
        dtThongMinh.nghe();
        dtThongMinh.goi();
        dtThongMinh.guiTinNhan();
        dtThongMinh.nhanTinNhan();
        dtThongMinh.suDung3G();
        dtThongMinh.chupHinh();
        dtThongMinh.tanCongKeXau();

        System.out.println("\n=== ĐIỆN THOẠI CỔ ĐIỂN ===");
        DienThoaiCoDien dtCoDien = new DienThoaiCoDien();
        dtCoDien.nghe();
        dtCoDien.goi();
        dtCoDien.guiTinNhan();
        dtCoDien.nhanTinNhan();
        dtCoDien.ngheRadio();
        dtCoDien.tanCongKeXau();
    }
}