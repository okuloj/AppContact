package com.example.contact;

public class CallLog {
    private String phoneNumber;
    private String timeDate;

    public CallLog(String phoneNumber, String timeDate) {
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
