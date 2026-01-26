package com.java.multiThreading;

public class PrintCounting {
    private int cnt = 1;
    public synchronized void printEven() {
        while (cnt < 20) {
//            if (cnt % 2 == 0) {
//                System.out.println(cnt++);
//                notify();
//            } else {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//
//                }
//            }
            while (cnt % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException ignored) {}
            }
            System.out.print(cnt++ + " ");
            notify();
        }
    }

    public synchronized void printOdd() {
        while (cnt < 20) {
//            if (cnt % 2 == 0) {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//
//                }
//            } else {
//                System.out.println(cnt++);
//                notify();
//            }
            while (cnt % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException ignored) {}
            }
            System.out.print(cnt++ + " ");
            notify();
        }
    }

    public static void main(String[] args) {
        PrintCounting printCounting = new PrintCounting();
        Thread t1 = new Thread(printCounting::printOdd);
        Thread t2 = new Thread(printCounting::printEven);

        t1.start();
        t2.start();
    }
}
