package com.java.multiThreading.synchronizedd;

public class MoviesBookApp extends Thread {
    private static BookTheaterSeat bookTheaterSeat;
    int seats;
    @Override
    public void run() {
        bookTheaterSeat.bookSeat(seats);
    }

    public static void main(String[] args) {
        bookTheaterSeat = new BookTheaterSeat();
        MoviesBookApp rahul = new MoviesBookApp();
        rahul.seats = 8;
        rahul.start();

        MoviesBookApp sandeep = new MoviesBookApp();
        sandeep.seats = 6;
        sandeep.start();
    }
}
