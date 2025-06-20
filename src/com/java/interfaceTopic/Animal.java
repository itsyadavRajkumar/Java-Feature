package com.java.interfaceTopic;

public interface Animal {
    void eat();
//    void run();
    default void sleep() {
        System.out.println("Sleep!");
    }
}
