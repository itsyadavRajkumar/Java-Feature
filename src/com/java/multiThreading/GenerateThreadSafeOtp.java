package com.java.multiThreading;

import java.security.SecureRandom;

public class GenerateThreadSafeOtp extends Thread {
    private synchronized String generateOtp() {
//        SecureRandom secureRandom = new SecureRandom();
//        int otp = 100000 + secureRandom.nextInt(900000);
        int otp = (int) (100000 + Math.random() * 900000);
        return String.valueOf(otp);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + generateOtp());
    }

    public static void main(String[] args) {
        GenerateThreadSafeOtp t1 = new GenerateThreadSafeOtp();
        GenerateThreadSafeOtp t2 = new GenerateThreadSafeOtp();
        GenerateThreadSafeOtp t3 = new GenerateThreadSafeOtp();

        t1.setName("T1 Thread");
        t2.setName("T2 Thread");
        t3.setName("T3 Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}
