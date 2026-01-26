package com.java.nimbus;

import java.util.Scanner;

public class ImplementConstructor {

    static class Book {
        private String title;
        private String author;
        private double price;

        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        public void display() {
            System.out.printf("Title: %s, Author: %s, Price: %.2f\n", title, author, price);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Book[] ob = new Book[n];
        for (int i = 0; i < n; ++i) {
            String title = scanner.nextLine();
            String author = scanner.nextLine();
            double price = scanner.nextDouble();
            scanner.nextLine();
            ob[i] = new Book(title, author, price);
        }

        System.out.println("Book Details: ");
        for (int i = 0; i < n; i++) {
            ob[i].display();
        }
        scanner.close();
    }
}