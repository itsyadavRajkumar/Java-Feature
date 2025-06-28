package com.java.multiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockFeature {

    private int cnt = 0;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private void incrementPointer() {
        reentrantLock.lock();
        try {
            for (int i = 0; i < 2000; i++) {
                cnt++;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockFeature obj = new ReentrantLockFeature();
        Thread t1 = new Thread(obj::incrementPointer);
        Thread t2 = new Thread(obj::incrementPointer);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(obj.cnt);
    }
}
