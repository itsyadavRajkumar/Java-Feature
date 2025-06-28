package com.java.multiThreading;

public class Volatile {

    private volatile int cnt = 0;

    private synchronized void increment() {
        for (int i = 0; i < 2000; i++) {
            cnt++;
        }
    }

    private boolean flag = false;

    private void setFlagTrue() {
        flag = true;
        System.out.println("flag is now true!!");
    }

    private void getFlagTrue() {
        while (!flag) {

        }
        System.out.println("getting the true state of flag!!");
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile obj = new Volatile();
        Thread t1 = new Thread(() -> {
            obj.increment();
        });

        Thread t2 = new Thread(obj::increment
        );

//        t1.start();
//        t2.start();

//        t1.join();
//        t2.join();

//        System.out.println(obj.cnt);



        Thread f1 = new Thread(()-> {
           obj.getFlagTrue();
        });

        Thread f2 = new Thread(obj::setFlagTrue);

        f1.start();
        f2.start();

        f1.join();
        f2.join();
    }
}
