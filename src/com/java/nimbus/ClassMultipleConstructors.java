package com.java.nimbus;

import java.util.Scanner;

public class ClassMultipleConstructors {
    static class Car {
        private String model;
        private int year;
        private double price;

        public Car() {
            this.model = "Unknown";
            this.year = 0;
            this.price = 0.0;
        }

        public Car(String model, int year) {
            this.model = model;
            this.year = year;
            this.price = 0.0;
        }

        public Car(String model, int year, double price) {
            this.model = model;
            this.year = year;
            this.price = price;
        }

        public void display() {
            System.out.printf("Model: %s, Year: %d, Price: %.2f%n", model, year, price);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            String model = sc.nextLine();
            int year = Integer.parseInt(sc.nextLine());
            double price = Double.parseDouble(sc.nextLine());

            if (price < 0) {
                cars[i] = new Car(model, year);
            } else {
                cars[i] = new Car(model, year, price);
            }
        }

        System.out.println("Car Details:");
        for (Car c : cars) {
            c.display();
        }

        sc.close();
    }
}
