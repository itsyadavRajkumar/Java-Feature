package com.java.multiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerKeyword {
    private AtomicInteger cnt = new AtomicInteger(0);

    private void incrementCounter() {
        for (int i = 0; i < 2000; i++) {
            cnt.incrementAndGet();
        }
    }

    private void printCounter() {
        System.out.println(cnt.get());
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerKeyword atomicInteger = new AtomicIntegerKeyword();
        Thread t1 = new Thread(atomicInteger::incrementCounter);
        Thread t2 = new Thread(atomicInteger::incrementCounter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        atomicInteger.printCounter();
    }
}
