package com.java.multiThreading;

public class MultiThreading {
    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 10; ++i) {
//            System.out.println("i: " + i);
//        }
//        Thread t1 = new Thread("T1 Thread");
//        System.out.println(t1.getName());
//        System.out.println(Thread.currentThread().getName());
//
//        Thread t2 = new Thread("T2 Thread");
//        t2 = new A("T2");
//        t2.run();
//        t1.join();
//        t2.join();
//        Timer timer = new Timer(false);
//        System.out.println(timer);
//        A a = new A("A Class!");
//
//        a.setDaemon(true);
//        a.start();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; ++i) {
                System.out.println(2 + " * " + i + " = " + (i * 2));
            }
            for (int i = 1; i <= 10; ++i) {
                System.out.println(3 + " * " + i + " = " + (i * 3));
            }
        });

//        Thread t2 = new Thread(()-> {
//            for (int i = 1; i <= 10; ++i) {
//                System.out.println(3 + " * " + i + " = " + (i * 3));
//            }
//        });
        t1.run();
//        t2.run();

    }
}
