package com.java.multiThreading;

public class ThreadSafe {
    static class Print {
        private volatile static int cnt = 0;
        public synchronized static void increment() {
            cnt++;
        }

        public static int getCnt() {
            return cnt;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(Print::increment);
        Thread t2 = new Thread(Print::increment);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(Print.getCnt());
    }
}
