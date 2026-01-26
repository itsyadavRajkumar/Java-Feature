package com.java.multiThreading.synchronizedd;

import java.util.concurrent.locks.ReentrantLock;

public class BookTheaterSeat {
    private int totalSeats = 10;
    private final ReentrantLock lock = new ReentrantLock();
    public void bookSeat(int seat) {
        try {
            lock.lock();
            if (totalSeats >= seat) {
                System.out.println(seat + " seats successfully booked!!");
                totalSeats -= seat;
                System.out.println(totalSeats + " seats left.");
            } else {
                System.out.println(seat + " seats not available!");
            }
        } finally {
            lock.unlock();
        }
    }
}
