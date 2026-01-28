package com.java.multiThreading.synchronizedd;

public class PrintCounterUsingSynchronizedBlock extends Thread {
    public PrintCounterUsingSynchronizedBlock(String name) {
        super(name);
    }

    public static int cnt = 0;

    private void increment() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                cnt++;
            }
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        increment();
    }

    public static void main(String[] args) throws InterruptedException {
        PrintCounterUsingSynchronizedBlock t1 = new PrintCounterUsingSynchronizedBlock("T1 Thread");
        PrintCounterUsingSynchronizedBlock t2 = new PrintCounterUsingSynchronizedBlock("T2 Thread");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(cnt);
    }
}
