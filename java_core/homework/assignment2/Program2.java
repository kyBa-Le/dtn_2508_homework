package java_core.homework.assignment2;

import java_core.homework.assignment1.*;

import java.util.Scanner;

public class Program2 {
    public static Department[] departments = new Department[5];
    public static Account[] accounts = new Account[5];
    public static Group[] groups = new Group[5];
    public static GroupAccount[] groupAccounts = new GroupAccount[10];

    public static void main(String[] args) {
        initializeData();
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập bài tập muốn chạy (1 - 6): ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                Exercise1.main(args);
                break;
            case 2:
                Exercise2.main(args);
                break;
            case 3:
                Exercise3.main(args);
                break;
            case 4:
                Exercise4.main(args);
                break;
            case 5:
                Exercise5.main(args);
                break;
            case 6:
                Exercise6.main(args);
                break;
            default:
                break;
        }

    }

    private static void initializeData() {
        departments[0] = new Department(1, "Sale");
        departments[1] = new Department(2, "Marketing");
        departments[2] = new Department(3, "IT");
        departments[3] = new Department(4, "HR");
        departments[4] = null;

        Position dev = new Position(1, "Dev");
        Position pm = new Position(2, "PM");
        Position test = new Position(3, "Test");

        accounts[0] = new Account(1, "admin@gmail.com", "admin", "Nguyễn Văn Admin", departments[0], dev, java.sql.Date.valueOf("2023-01-01"));
        accounts[1] = new Account(2, "user1@gmail.com", "user1", "Trần Thị User", null, test, java.sql.Date.valueOf("2023-02-01"));
        accounts[2] = new Account(3, "user2@gmail.com", "user2", "Lê Văn User", departments[1], pm, java.sql.Date.valueOf("2023-03-01"));
        accounts[3] = new Account(4, "user3@gmail.com", "user3", "Phạm Minh User", departments[2], dev, java.sql.Date.valueOf("2023-04-01"));
        accounts[4] = new Account(5, "user4@gmail.com", "user4", "Hoàng Lan User", departments[0], test, java.sql.Date.valueOf("2023-05-01"));

        groups[0] = new Group(1, "Java Fresher", accounts[0], java.sql.Date.valueOf("2023-01-10"));
        groups[1] = new Group(2, "C# Fresher", accounts[0], java.sql.Date.valueOf("2023-02-10"));
        groups[2] = new Group(3, "DB Group", accounts[1], java.sql.Date.valueOf("2023-03-10"));

        groupAccounts[0] = new GroupAccount(groups[0], accounts[0], java.sql.Date.valueOf("2023-01-15"));
        groupAccounts[1] = new GroupAccount(groups[0], accounts[1], java.sql.Date.valueOf("2023-01-20"));
        groupAccounts[2] = new GroupAccount(groups[1], accounts[1], java.sql.Date.valueOf("2023-02-15"));
        groupAccounts[3] = new GroupAccount(groups[2], accounts[1], java.sql.Date.valueOf("2023-03-15"));
    }
}
