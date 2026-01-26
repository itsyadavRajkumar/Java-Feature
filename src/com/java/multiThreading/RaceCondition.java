package com.java.multiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class RaceCondition {
    volatile static int cnt = 0;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                lock.lock();
                try {
                    cnt++;
                } finally {
                    lock.unlock();
                }
            }
        };


        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(cnt);

    }
}
