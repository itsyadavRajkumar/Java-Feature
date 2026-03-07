package com.java.multiThreading.synchronizedd;

public class BusApplication {
    public static void main(String[] args) {
        BookBusTickets b1 = new BookBusTickets();
        ThreadWeb t1 = new ThreadWeb("T1",7, b1);
        ThreadMobile t2 = new ThreadMobile("T2", 15, b1);

        t1.start();
        t2.start();

        BookBusTickets b2 = new BookBusTickets();

        ThreadWeb t3 = new ThreadWeb("T3", 7, b2);
        ThreadMobile t4 = new ThreadMobile("T4", 15, b2);

        t3.start();
        t4.start();
    }
}
