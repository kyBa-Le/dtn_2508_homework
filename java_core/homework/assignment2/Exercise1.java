package java_core.homework.assignment2;

import java_core.homework.assignment1.Account;
import java_core.homework.assignment1.Department;
import java_core.homework.assignment1.Group;
import java_core.homework.assignment1.GroupAccount;

import static java_core.homework.assignment2.Program2.*;


public class Exercise1 {
    public static void main(String[] args) {

        System.out.println("=== Exercise 1: Flow Control ===");

        // Question 1: Check department of account[1] (index 1 = account thứ 2)
        Account acc2 = accounts[1];
        if (acc2.getDepartment() == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + acc2.getDepartment().getDepartmentName());
        }

        // Question 2: Check number of groups for account thứ 2
        int groupCount = countGroupsOfAccount(acc2);
        if (groupCount == 0) {
            System.out.println("Nhân viên này chưa tham gia group nào");
        } else if (groupCount <= 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (groupCount == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }

        // Question 3: Ternary for Question 1
        System.out.println(acc2.getDepartment() == null ?
                "Nhân viên này chưa có phòng ban" :
                "Phòng ban của nhân viên này là " + acc2.getDepartment().getDepartmentName());

        // Question 4: Ternary for Position of account thứ 1
        Account acc1 = accounts[0];
        System.out.println(acc1.getPosition().getPositionName().equals("Dev") ?
                "Đây là Developer" : "Người này không phải là Developer");

        // Question 5: Switch case for group member count (group thứ 1)
        int memberCount = countMembersInGroup(groups[0]);
        switch (memberCount) {
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
        }

        // Question 6: Switch case for Question 2
        switch (groupCount) {
            case 0:
                System.out.println("Nhân viên này chưa tham gia group nào");
                break;
            case 1:
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }

        // Question 7: Switch case for Question 4
        switch (acc1.getPosition().getPositionName()) {
            case "Dev":
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
        }

        // Question 8: FOREACH - Print account info with department
        System.out.println("\n--- Account List ---");
        for (Account acc : accounts) {
            if (acc != null) {
                String deptName = (acc.getDepartment() == null) ? "Chưa có phòng ban" : acc.getDepartment().getDepartmentName();
                System.out.println("Email: " + acc.getEmail() + ", FullName: " + acc.getFullName() + ", Department: " + deptName);
            }
        }

        // Question 9: FOREACH - Print departments
        System.out.println("\n--- Department List ---");
        for (Department dept : departments) {
            if (dept != null) {
                System.out.println("ID: " + dept.getDepartmentId() + ", Name: " + dept.getDepartmentName());
            }
        }

        // Question 10: FOR - Detailed account info
        System.out.println("\n--- Detailed Account Info ---");
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                Account a = accounts[i];
                String deptName = (a.getDepartment() == null) ? "N/A" : a.getDepartment().getDepartmentName();
                System.out.printf("Thông tin account thứ %d là:%n", i + 1);
                System.out.println("Email: " + a.getEmail());
                System.out.println("Full name: " + a.getFullName());
                System.out.println("Phòng ban: " + deptName);
            }
        }

        // Question 11: FOR - Detailed department info
        System.out.println("\n--- Detailed Department Info ---");
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null) {
                System.out.printf("Thông tin department thứ %d là:%n", i + 1);
                System.out.println("Id: " + departments[i].getDepartmentId());
                System.out.println("Name: " + departments[i].getDepartmentName());
            }
        }

        // Question 12: Only first 2 departments
        System.out.println("\n--- First 2 Departments ---");
        for (int i = 0; i < 2 && i < departments.length; i++) {
            if (departments[i] != null) {
                System.out.printf("Thông tin department thứ %d là:%n", i + 1);
                System.out.println("Id: " + departments[i].getDepartmentId());
                System.out.println("Name: " + departments[i].getDepartmentName());
            }
        }

        // Question 13: All accounts except second
        System.out.println("\n--- All accounts except second ---");
        for (int i = 0; i < accounts.length; i++) {
            if (i != 1 && accounts[i] != null) {
                System.out.println(accounts[i].getFullName());
            }
        }

        // Question 14: Accounts with id < 4
        System.out.println("\n--- Accounts with ID < 4 ---");
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountId() < 4) {
                System.out.println(accounts[i].getFullName());
            }
        }

        // Question 15: Even numbers <= 20
        System.out.println("\n--- Even numbers <= 20 ---");
        for (int i = 0; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // Question 16: WHILE version of FOR questions (example for Q15)
        System.out.println("\n--- Even numbers using WHILE ---");
        int num = 0;
        while (num <= 20) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
            num++;
        }
        System.out.println();

        // Question 17: DO-WHILE version
        System.out.println("\n--- Even numbers using DO-WHILE ---");
        num = 0;
        do {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
            num++;
        } while (num <= 20);
        System.out.println();
    }

    private static int countGroupsOfAccount(Account acc) {
        int count = 0;
        for (GroupAccount ga : groupAccounts) {
            if (ga != null && ga.getAccount().equals(acc)) count++;
        }
        return count;
    }

    private static int countMembersInGroup(Group group) {
        int count = 0;
        for (GroupAccount ga : groupAccounts) {
            if (ga != null && ga.getGroup().equals(group)) count++;
        }
        return count;
    }
}
