package com.java.nimbus;

//Enhance your coding skills, start writing your code here!!
import java.util.Scanner;

public class ConstructorOverload {

    static class Book {
        private String title;
        private String author;
        private double price;

        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.price = 0.00;
        }

        public void display() {
            System.out.printf("Title: %s, Author: %s, Price: %.2f%n", title, author, price);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Book[] books = new Book[n];
        for (int i = 0; i < n; ++i) {
            String title = scanner.nextLine();
            String author = scanner.nextLine();
            double price = scanner.nextDouble();
            scanner.nextLine();

            if (price == 0.0) {
                books[i] = new Book(title, author);
            } else {
                books[i] = new Book(title, author, price);
            }
        }

        System.out.println("Book Details:");
        for (Book b : books) {
            b.display();
        }

        scanner.close();
    }
}
