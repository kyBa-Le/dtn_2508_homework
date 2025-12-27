package java_core.homework.assignment4.com.vti.entity.Exercise6;

public class VietnamesePhone extends Phone {

    @Override
    public void insertContact(String name, String phone) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Tên liên lạc đã tồn tại!");
                return;
            }
        }
        contacts.add(new Contact(name, phone));
        System.out.println("Thêm liên lạc thành công: " + name);
    }

    @Override
    public void removeContact(String name) {
        boolean removed = contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Xóa liên lạc thành công: " + name);
        } else {
            System.out.println("Không tìm thấy liên lạc: " + name);
        }
    }

    @Override
    public void updateContact(String name, String newPhone) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                c.setPhone(newPhone);
                System.out.println("Cập nhật số điện thoại thành công cho: " + name);
                return;
            }
        }
        System.out.println("Không tìm thấy liên lạc để cập nhật: " + name);
    }

    @Override
    public void searchContact(String name) {
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy liên lạc nào chứa: " + name);
        }
    }

    public void printAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống.");
            return;
        }
        System.out.println("=== Danh bạ ===");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}