package java_core.homework.assignment2;

import java_core.homework.assignment1.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Exercise5 {

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("=== Exercise 5: Input from console ===");
        runMainMenu(); // Chạy menu chính cho Question 8, 10, 11
    }

    // =================================== MENU CHÍNH (Q8 → Q10 → Q11) ===================================
    private static void runMainMenu() {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
            System.out.println("1. Tạo account");
            System.out.println("2. Tạo department");
            System.out.println("3. Thêm group vào account (chọn thủ công)");
            System.out.println("4. Thêm account vào group ngẫu nhiên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (choice == 0) {
                System.out.println("Thoát chương trình. Tạm biệt!");
                return;
            }

            switch (choice) {
                case 1 -> createAccountFromInput();
                case 2 -> createDepartmentFromInput();
                case 3 -> addGroupToAccountManually();
                case 4 -> addAccountToRandomGroup();
                default -> System.out.println("Mời bạn nhập lại!");
            }

            // Hỏi có muốn tiếp tục không (Question 10)
            System.out.print("\nBạn có muốn thực hiện chức năng khác không? (Có/Không): ");
            String continueAns = scanner.nextLine().trim().toLowerCase();
            if (!continueAns.equals("có") && !continueAns.equals("co") && !continueAns.equals("yes") && !continueAns.equals("y")) {
                System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                return;
            }
        }
    }

    // Question 5: Tạo Account từ input
    private static void createAccountFromInput() {
        System.out.println("\n=== Tạo Account mới ===");
        System.out.print("Nhập Email: ");
        String email = scanner.nextLine();

        System.out.print("Nhập Full Name: ");
        String fullName = scanner.nextLine();

        System.out.println("Chọn Position:");
        System.out.println("1. Dev");
        System.out.println("2. Test");
        System.out.println("3. Scrum Master");
        System.out.println("4. PM");
        System.out.print("Nhập lựa chọn (1-4): ");
        int posChoice = scanner.nextInt();
        scanner.nextLine();

        Position position = switch (posChoice) {
            case 1 -> new Position(1, "Dev");
            case 2 -> new Position(2, "Test");
            case 3 -> new Position(3, "Scrum Master");
            case 4 -> new Position(4, "PM");
            default -> {
                System.out.println("Lựa chọn không hợp lệ → mặc định Dev");
                yield new Position(1, "Dev");
            }
        };

        // Tìm hoặc tạo "Waiting Room" department
        Department waitingDept = findOrCreateDepartment("Waiting Room");

        // Tìm slot trống trong mảng accounts
        int newId = 1;
        for (Account acc : Program2.accounts) {
            if (acc != null) newId = Math.max(newId, acc.getAccountId() + 1);
        }

        Account newAcc = new Account(newId, email,
                email.contains("@") ? email.substring(0, email.indexOf('@')) : email,
                fullName, waitingDept, position, Date.valueOf(LocalDate.now()));

        // Thêm vào mảng
        for (int i = 0; i < Program2.accounts.length; i++) {
            if (Program2.accounts[i] == null) {
                Program2.accounts[i] = newAcc;
                break;
            }
        }

        System.out.println("Tạo account thành công!");
        System.out.println("ID: " + newAcc.getAccountId() + " | Name: " + newAcc.getFullName() +
                " | Position: " + newAcc.getPosition().getPositionName());
    }

    // Question 6: Tạo Department từ input
    private static void createDepartmentFromInput() {
        System.out.println("\n=== Tạo Department mới ===");
        System.out.print("Nhập tên Department: ");
        String deptName = scanner.nextLine();

        Department dept = findOrCreateDepartment(deptName);
        System.out.println("Department '" + dept.getDepartmentName() + "' đã được tạo/thêm (ID = " + dept.getDepartmentId() + ")");
    }

    // Helper: tìm hoặc tạo department trong mảng departments
    private static Department findOrCreateDepartment(String name) {
        for (Department d : Program2.departments) {
            if (d != null && d.getDepartmentName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        int newId = 1;
        for (Department d : Program2.departments) {
            if (d != null) newId = Math.max(newId, d.getDepartmentId() + 1);
        }
        Department newDept = new Department(newId, name);
        for (int i = 0; i < Program2.departments.length; i++) {
            if (Program2.departments[i] == null) {
                Program2.departments[i] = newDept;
                break;
            }
        }
        return newDept;
    }

    // Question 9: Thêm group vào account (chọn thủ công)
    private static void addGroupToAccountManually() {
        System.out.println("\n=== Thêm Group vào Account (chọn thủ công) ===");

        // In danh sách username
        System.out.println("Danh sách username hiện có:");
        boolean hasAccount = false;
        for (Account acc : Program2.accounts) {
            if (acc != null) {
                System.out.println("- " + acc.getUsername());
                hasAccount = true;
            }
        }
        if (!hasAccount) {
            System.out.println("Chưa có account nào!");
            return;
        }

        System.out.print("Nhập username của account: ");
        String username = scanner.nextLine();

        Account selectedAcc = null;
        for (Account acc : Program2.accounts) {
            if (acc != null && acc.getUsername().equals(username)) {
                selectedAcc = acc;
                break;
            }
        }
        if (selectedAcc == null) {
            System.out.println("Không tìm thấy username này!");
            return;
        }

        // In danh sách group
        System.out.println("Danh sách group hiện có:");
        boolean hasGroup = false;
        for (Group g : Program2.groups) {
            if (g != null) {
                System.out.println("- " + g.getGroupName());
                hasGroup = true;
            }
        }
        if (!hasGroup) {
            System.out.println("Chưa có group nào!");
            return;
        }

        System.out.print("Nhập tên group muốn thêm: ");
        String groupName = scanner.nextLine();

        Group selectedGroup = null;
        for (Group g : Program2.groups) {
            if (g != null && g.getGroupName().equalsIgnoreCase(groupName)) {
                selectedGroup = g;
                break;
            }
        }
        if (selectedGroup == null) {
            System.out.println("Không tìm thấy group này!");
            return;
        }

        // Thêm vào groupAccounts
        GroupAccount ga = new GroupAccount(selectedGroup, selectedAcc, Date.valueOf(LocalDate.now()));
        for (int i = 0; i < Program2.groupAccounts.length; i++) {
            if (Program2.groupAccounts[i] == null) {
                Program2.groupAccounts[i] = ga;
                break;
            }
        }

        System.out.println("Đã thêm " + selectedAcc.getFullName() + " vào group \"" + selectedGroup.getGroupName() + "\" thành công!");
    }

    // Question 11: Thêm account vào group ngẫu nhiên
    private static void addAccountToRandomGroup() {
        System.out.println("\n=== Thêm Account vào Group ngẫu nhiên ===");

        // Kiểm tra có account không
        boolean hasAccount = false;
        for (Account acc : Program2.accounts) {
            if (acc != null) hasAccount = true;
        }
        if (!hasAccount) {
            System.out.println("Chưa có account nào!");
            return;
        }

        // In danh sách username
        System.out.println("Danh sách username:");
        for (Account acc : Program2.accounts) {
            if (acc != null) {
                System.out.println("- " + acc.getUsername());
            }
        }

        System.out.print("Nhập username của account: ");
        String username = scanner.nextLine();

        Account selectedAcc = null;
        for (Account acc : Program2.accounts) {
            if (acc != null && acc.getUsername().equals(username)) {
                selectedAcc = acc;
                break;
            }
        }
        if (selectedAcc == null) {
            System.out.println("Không tìm thấy username!");
            return;
        }

        // Chọn ngẫu nhiên group có dữ liệu
        int validGroupCount = 0;
        for (Group g : Program2.groups) {
            if (g != null) validGroupCount++;
        }
        if (validGroupCount == 0) {
            System.out.println("Chưa có group nào!");
            return;
        }

        Group randomGroup = null;
        int randomIndex = random.nextInt(validGroupCount);
        int count = 0;
        for (Group g : Program2.groups) {
            if (g != null) {
                if (count == randomIndex) {
                    randomGroup = g;
                    break;
                }
                count++;
            }
        }

        // Thêm vào groupAccounts
        GroupAccount ga = new GroupAccount(randomGroup, selectedAcc, Date.valueOf(LocalDate.now()));
        for (int i = 0; i < Program2.groupAccounts.length; i++) {
            if (Program2.groupAccounts[i] == null) {
                Program2.groupAccounts[i] = ga;
                break;
            }
        }

        System.out.println("Đã thêm " + selectedAcc.getFullName() +
                " vào group ngẫu nhiên: \"" + randomGroup.getGroupName() + "\"");
    }
}