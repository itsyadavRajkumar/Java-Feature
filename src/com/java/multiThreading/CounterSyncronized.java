package com.java.multiThreading;

public class CounterSyncronized extends Thread {
    private static int cnt = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            cnt++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CounterSyncronized t1 = new CounterSyncronized();
        CounterSyncronized t2 = new CounterSyncronized();

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(cnt);
    }
}
