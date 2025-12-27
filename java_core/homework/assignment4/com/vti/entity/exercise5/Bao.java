package java_core.homework.assignment4.com.vti.entity.exercise5;

import java.time.LocalDate;

public class Bao extends TaiLieu {
    private LocalDate ngayPhatHanh;

    public Bao(String maTaiLieu, String tenNXB, int soBanPhatHanh, LocalDate ngayPhatHanh) {
        super(maTaiLieu, tenNXB, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public String toString() {
        return "[Báo] " + super.toString() + ", Ngày phát hành: " + ngayPhatHanh;
    }
}
