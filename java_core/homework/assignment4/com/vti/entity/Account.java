package java_core.homework.assignment4.com.vti.entity;

import java.sql.Date;

public class Account {
    private int accountId;
    private String email;
    private String username;
    private String fullName;
    private Department department;
    private Position position;
    private Date createDate;

    public Account() {
        this.createDate = Date.valueOf(java.time.LocalDate.now());
    }

    public Account(int accountId, String email, String username,
                   String firstName, String lastName) {
        this.accountId = accountId;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
        this.createDate = Date.valueOf(java.time.LocalDate.now());
    }

    public Account(int accountId, String email, String username, String fullName,
                   Department department, Position position, Date createDate) {
        this.accountId = accountId;
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }

    public Account(int accountId, String email, String username,
                   String firstName, String lastName, Position position) {
        this.accountId = accountId;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate = Date.valueOf(java.time.LocalDate.now());
    }

    public Account(int accountId, String email, String username,
                   String firstName, String lastName, Position position, Date createDate) {
        this.accountId = accountId;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate = createDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Email: " + email + ", " + "Full Name: " + fullName + ", " + "Department: " + department;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account a) {
            return accountId == a.getAccountId();
        }
        return false;
    }
}