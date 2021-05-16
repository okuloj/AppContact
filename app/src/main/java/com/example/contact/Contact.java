package com.example.contact;

import android.graphics.Bitmap;

public class Contact {
    private String name;
    private String phone;
    private Bitmap photo;

    public Contact(String name, String phone, Bitmap photo) {
        this.name = name;
        this.phone = phone;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Bitmap getPhoto() {
        return photo;
    }
}
