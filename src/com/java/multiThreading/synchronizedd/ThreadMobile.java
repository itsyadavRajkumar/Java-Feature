package com.java.multiThreading.synchronizedd;

public class ThreadMobile extends Thread{
    private final int seat;
    private BookBusTickets bookBusTickets;


    public ThreadMobile(String name, int seat, BookBusTickets bookBusTickets) {
        super(name);
        this.seat = seat;
        this.bookBusTickets = bookBusTickets;
    }

    @Override
    public void run() {
        bookBusTickets.bookSeat(seat, Thread.currentThread().getName());
    }
}
