package com.java.nimbus;

import java.util.Scanner;

public class MultipleConstructors {

    static class Book {
        private String title;
        private String author;
        private double price;

        // Default constructor
        public Book() {
            this.title = "Unknown";
            this.author = "Unknown";
            this.price = 0.0;
        }

        // Constructor with title and author
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.price = 0.0;
        }

        // Constructor with title, author, and price
        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        // Method to display book details
        public void display() {
            System.out.printf("Title: %s, Author: %s, Price: %.2f%n", title, author, price);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            String title = sc.nextLine();
            String author = sc.nextLine();
            double price = Double.parseDouble(sc.nextLine());

            if (price < 0) {
                books[i] = new Book(title, author);  // use constructor with title & author only
            } else {
                books[i] = new Book(title, author, price); // use full constructor
            }
        }

        System.out.println("Book Details:");
        for (Book b : books) {
            b.display();
        }

        sc.close();
    }
}

