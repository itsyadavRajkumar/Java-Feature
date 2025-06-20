package com.java.claases;

public interface MyApplication {
    int x = 2122;

    default String generateOtp() {
        return "123456";
    }

    default String saveToDB(String username) {
        return "";
    }

    default String verifyOtp(String username, String otp) {
        return "";
    }

    String sendOtp(String username, String otp);
}
