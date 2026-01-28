package com.java.multiThreading.synchronizedd;

public class PrintCounterUsingSynchronizedMethod {
    public static int cnt = 0;

    synchronized public void increment() {
        for (int i = 0; i < 100; i++) {
            cnt++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintCounterUsingSynchronizedMethod print = new PrintCounterUsingSynchronizedMethod();
        Thread t1 = new Thread(print::increment);
        Thread t2 = new Thread(print::increment);
        Thread t3 = new Thread(print::increment);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(cnt);
    }
}
