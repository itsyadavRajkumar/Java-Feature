package com.java.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceMultipleThread {
    public static void main(String[] args) {

//      1.. n thread created and running in parallel
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Task 1 -> " + i);
            }
        });

        executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Task 2 -> " + i);
            }
        });

        executor.shutdown();

    }
}
