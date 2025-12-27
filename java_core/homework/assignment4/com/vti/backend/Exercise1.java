package java_core.homework.assignment4.com.vti.backend;

import java_core.homework.assignment4.com.vti.entity.Account;
import java_core.homework.assignment4.com.vti.entity.Department;
import java_core.homework.assignment4.com.vti.entity.Group;
import java_core.homework.assignment4.com.vti.entity.Position;

import java.sql.Date;
import java.time.LocalDate;

public class Exercise1 {
    public static void main(String[] args) {

        // QUESTION 1:
        // Tạo constructor cho department:
        //   a) Không có parameters
        //   b) Có 1 parameter là nameDepartment và default id của Department = 0
        // Khởi tạo 1 Object với mỗi constructor ở trên

        Department dept1 = new Department();
        Department dept2 = new Department("Sale");


        // QUESTION 2:
        // Tạo constructor cho Account:
        //   a) Không có parameters
        //   b) Có các parameter là id, Email, Username, FirstName, LastName
        //      (với FullName = FirstName + LastName)
        //   c) Có các parameter là id, Email, Username, FirstName, LastName
        //      (với FullName = FirstName + LastName) và Position của User, default createDate = now
        //   d) Có các parameter là id, Email, Username, FirstName, LastName
        //      (với FullName = FirstName + LastName) và Position của User, createDate.
        // Khởi tạo 1 Object với mỗi constructor ở trên.

        Account acc1 = new Account();
        Account acc2 = new Account(2, "nguyenvana@gmail.com", "nguyenvana", "Nguyễn", "Văn A");
        Position devPosition = new Position(1, "Dev");
        Account acc3 = new Account(3, "tranb@gmail.com", "tranb", "Trần", "Thị B", devPosition);
        Account acc4 = new Account(4, "levanc@gmail.com", "levanc", "Lê", "Văn C", devPosition, Date.valueOf("2023-01-01"));

        // QUESTION 3:
        // Tạo constructor cho Group:
        //   a) Không có parameters
        //   b) Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
        //   c) Có các parameter là GroupName, Creator, array String[] usernames, CreateDate
        //      Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các thông tin còn lại = null).
        // Khởi tạo 1 Object với mỗi constructor ở trên.

        Group group1 = new Group();
        Account creator = acc2;
        Account[] members = {acc2, acc3, acc4};
        Date groupCreateDate = Date.valueOf(LocalDate.now());
        Group group2 = new Group("Java Fresher", creator, members, groupCreateDate);
        String[] usernames = {"userX", "userY", "userZ"};
        Group group3 = new Group("Backend Team", creator, usernames, groupCreateDate);
    }
}