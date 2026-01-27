package com.java.multiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class CounterReentrantLock implements Runnable {
    private int cnt = 0;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < 10; ++i) {
                cnt++;
            }
        } finally {
            lock.unlock();
        }
    }

    public int getCnt() {
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        CounterReentrantLock cnt = new CounterReentrantLock();

        Thread t1 = new Thread(cnt);
        Thread t2 = new Thread(cnt);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(cnt.getCnt());
    }
}
