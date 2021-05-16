package com.example.contact;

public class mCallLog {
    private String phoneNumber;
    private String timeDate;

    public mCallLog(String phoneNumber, String timeDate) {
        this.phoneNumber = phoneNumber;
        this.timeDate = timeDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTimeDate() {
        return timeDate;
    }


}
