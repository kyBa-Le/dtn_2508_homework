package java_core.homework.assignment4.com.vti.entity.Exercise6;

import java.util.ArrayList;

public abstract class Phone {
    protected ArrayList<Contact> contacts;

    public Phone() {
        this.contacts = new ArrayList<>();
    }

    public abstract void insertContact(String name, String phone);

    public abstract void removeContact(String name);

    public abstract void updateContact(String name, String newPhone);

    public abstract void searchContact(String name);
}

class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone;
    }
}
