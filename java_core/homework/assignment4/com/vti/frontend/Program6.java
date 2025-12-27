package java_core.homework.assignment4.com.vti.frontend;

import java_core.homework.assignment4.com.vti.entity.Exercise6.Employee;
import java_core.homework.assignment4.com.vti.entity.Exercise6.Manager;
import java_core.homework.assignment4.com.vti.entity.Exercise6.VietnamesePhone;
import java_core.homework.assignment4.com.vti.entity.Exercise6.Waiter;

public class Program6 {
    public static void main(String[] args) {
        VietnamesePhone phone = new VietnamesePhone();

        phone.insertContact("Nguyễn Văn A", "0123456789");
        phone.insertContact("Trần Thị B", "0987654321");
        phone.insertContact("Lê Văn C", "0111222333");

        phone.printAllContacts();

        System.out.println("\nTìm kiếm 'Văn':");
        phone.searchContact("Văn");

        System.out.println("\nCập nhật số cho 'Trần Thị B':");
        phone.updateContact("Trần Thị B", "0999888777");

        System.out.println("\nXóa 'Lê Văn C':");
        phone.removeContact("Lê Văn C");

        System.out.println("\nDanh bạ sau khi thay đổi:");
        phone.printAllContacts();
    }
}

class DemoUser {
    public static void main(String[] args) {
        Employee emp = new Employee("Nguyễn Văn A", 3.5);
        Manager mgr = new Manager("Trần Thị B", 5.0);
        Waiter waiter = new Waiter("Lê Văn C", 2.0);

        System.out.println("=== Thông tin nhân viên ===");
        emp.displayInfo();
        mgr.displayInfo();
        waiter.displayInfo();
    }
}
