package com.java.multiThreading;

public class SingleThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        SingleThread t1 = new SingleThread();
        t1.start();
    }
}
