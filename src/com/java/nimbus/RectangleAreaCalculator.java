package com.java.nimbus;

import java.util.Scanner;

public class RectangleAreaCalculator {

    static class Rectangle {
        private int length;
        private int breadth;

        public Rectangle() {
            this.length = 1;
            this.breadth = 1;
        }

        public Rectangle(int length, int breadth) {
            this.length = length;
            this.breadth = breadth;
        }

        public int getArea() {
            return length * breadth;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Rectangle[] rectangles = new Rectangle[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                rectangles[i] = new Rectangle();
            } else {
                String[] parts = line.split(" ");
                int length = Integer.parseInt(parts[0]);
                int breadth = Integer.parseInt(parts[1]);
                rectangles[i] = new Rectangle(length, breadth);
            }
        }

        for (Rectangle rect : rectangles) {
            System.out.println(rect.getArea());
        }

        sc.close();
    }
}
