package com.java.nimbus;

import java.util.Scanner;

public class DisplayDetails {

    static class Laptop {
        private String brand;
        private String model;
        private double price;
        private int year;

        public Laptop(String brand, String model, double price, int year) {
            this.brand = brand;
            this.model = model;
            this.price = price;
            this.year = year;
        }

        public void display() {
            System.out.printf("Brand: %s, Model: %s, Price: %.2f, Year: %d%n", brand, model, price, year);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Laptop[] laptops = new Laptop[n];
        for (int i = 0; i < n; i++) {
            String brand = sc.nextLine();
            String model = sc.nextLine();
            double price = Double.parseDouble(sc.nextLine());
            int year = Integer.parseInt(sc.nextLine());

            laptops[i] = new Laptop(brand, model, price, year);
        }

        System.out.println("Laptop Details:");
        for (Laptop laptop : laptops) {
            laptop.display();
        }

        sc.close();
    }
}
