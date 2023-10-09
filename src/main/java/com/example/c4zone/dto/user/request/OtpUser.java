package com.example.c4zone.dto.user.request;

public class OtpUser {
    private String username;
    private String otp;

    public OtpUser(String username, String otp) {
        this.username = username;
        this.otp = otp;
    }

    public OtpUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
