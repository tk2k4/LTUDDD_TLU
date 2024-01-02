package com.example.ltuddd_tlu.tuan3.tuan32_Java;

public class Contact {
    private String Avatar;
    private String Name;
    private String Phone;

    public Contact(String name, String phone, String avatar) {
        this.Avatar = avatar;
        this.Name = name;
        this.Phone = phone;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
