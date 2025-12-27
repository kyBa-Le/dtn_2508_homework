package java_core.homework.assignment4.com.vti.entity.exercise4;


public class Student {
    private int id;
    private String name;
    private String hometown;
    private double diemHocLuc;

    public Student(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
        this.diemHocLuc = 0;
    }

    public void setDiemHocLuc(double diem) {
        this.diemHocLuc = diem;
    }

    public void congDiem(double diemCong) {
        this.diemHocLuc += diemCong;
    }

    public void inThongTin() {
        System.out.println("Tên: " + name);
        System.out.println("Quê quán: " + hometown);
        System.out.print("Điểm học lực: " + diemHocLuc + " -> Xếp loại: ");

        if (diemHocLuc < 4.0) {
            System.out.println("Yếu");
        } else if (diemHocLuc < 6.0) {
            System.out.println("Trung bình");
        } else if (diemHocLuc < 8.0) {
            System.out.println("Khá");
        } else {
            System.out.println("Giỏi");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}