package com.java.multiThreading.synchronizedd;

public class ThreadWeb extends Thread {
    BookBusTickets bookBusTickets;
    private final int seat;
    public ThreadWeb(String name, int seat, BookBusTickets bookBusTickets) {
        super(name);
        this.seat = seat;
        this.bookBusTickets = bookBusTickets;
    }
    @Override
    public void run() {
        bookBusTickets.bookSeat(seat, Thread.currentThread().getName());
    }
}
