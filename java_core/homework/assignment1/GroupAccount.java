package java_core.homework.assignment1;

public class GroupAccount {
    private Group group;
    private Account account;
    private java.sql.Date joinDate;

    public GroupAccount() {
    }

    public GroupAccount(Group group, Account account, java.sql.Date joinDate) {
        this.group = group;
        this.account = account;
        this.joinDate = joinDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public java.sql.Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(java.sql.Date joinDate) {
        this.joinDate = joinDate;
    }
}