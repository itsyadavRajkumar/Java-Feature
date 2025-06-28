package com.java.multiThreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreFeature {
    private static final Semaphore rateLimiter = new Semaphore(3);

    public static void apiCall(String threadName) {
        try {
            System.out.println(threadName + " is calling!!");
            rateLimiter.acquire();
            System.out.println("Getting permission for " + threadName + " call!!");
            Thread.sleep(2000);
            System.out.println("Finish the " + threadName + " call!");
        } catch (InterruptedException exception){
            exception.printStackTrace();
        } finally {
            rateLimiter.release();
            System.out.println("Release the permit of " + threadName);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String threadName = "Client-" + i;
            Thread thread = new Thread(()-> apiCall(threadName));
            thread.start();
        }
    }
}
