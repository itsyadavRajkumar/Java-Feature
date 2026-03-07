package com.java.multiThreading.synchronizedd;

public class BookBusTickets {
    public static int totalSeat = 20;
    static synchronized public void bookSeat(int seat, String name) {
        if (seat <= totalSeat) {
            System.out.println(name + " Thread " + seat + " seats booked successfully!");
            totalSeat -= seat;
            System.out.println(name + " Thread " + totalSeat + " seats left");
        } else {
            System.out.println(name + " Thread " + seat + " seats not available!");
        }
    }
}
