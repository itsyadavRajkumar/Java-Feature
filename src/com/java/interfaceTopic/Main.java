package com.java.interfaceTopic;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat();

        Animal animal1 = () -> System.out.println("eat");
        Animal animal2 = () -> System.out.println("animal Eat");

        animal1.eat();
        animal2.eat();
    }
}