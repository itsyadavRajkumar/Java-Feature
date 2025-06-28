package com.java.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSingleThread {
    public static void main(String[] args) {
//        Single Thread Created only and run in sequential order
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Task 1 -> " + i);
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Task 2 -> " + i);
            }
        });

        executorService.shutdown();

    }
}
