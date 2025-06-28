package com.java.multiThreading;

public class CreateThread extends Thread {
    CreateThread(String name) {
        super(name);
        System.out.println("Constructor: " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("Run Method: " + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("A class!!");
        }
    }

    public static void main(String[] args) {
        CreateThread createThread = new CreateThread("Thread");
        System.out.println("Main Method: " + Thread.currentThread().getName());
        createThread.start();
    }
}
