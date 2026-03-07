package com.java.multiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class RunnableInterface implements Runnable {
    int cnt = 0;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
//        synchronized (RunnableInterface.class) {
//            for (int i = 0; i < 10000; i++) {
//                cnt++;
//            }
//        }
        for (int i = 0; i < 10000; i++) {
            atomicInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableInterface ob = new RunnableInterface();
        Thread t1 = new Thread(ob);
        t1.start();
        Thread t2 = new Thread(ob);
        t2.start();

        t1.join();
        t2.join();

        System.out.println(ob.atomicInteger);
    }
}
