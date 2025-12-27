package java_core.homework.assignment4.com.vti.entity;

import java.sql.Date;

public class Group {
    private int groupId;
    private String groupName;
    private Account creator;
    private Account[] accounts;
    private Date createDate;

    public Group() {
        this.createDate = Date.valueOf(java.time.LocalDate.now());
    }

    public Group(String groupName, Account creator, Account[] accounts, Date createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }

    public Group(String groupName, Account creator, String[] usernames, Date createDate) {
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;

        if (usernames != null) {
            this.accounts = new Account[usernames.length];
            for (int i = 0; i < usernames.length; i++) {
                Account tempAcc = new Account();
                tempAcc.setUsername(usernames[i]);
                this.accounts[i] = tempAcc;
            }
        } else {
            this.accounts = null;
        }
    }

    public Group(int groupId, String groupName, Account creator, Date createDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}