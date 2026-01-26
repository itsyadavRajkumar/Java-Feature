package com.java.nimbus;

import java.util.Scanner;

public class OverloadedDistanceCalculator {

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double distanceTo(Point p) {
            int dx = this.x - p.x;
            int dy = this.y - p.y;
            return Math.sqrt(dx * dx + dy * dy);
        }

        public double distanceTo() {
            return Math.sqrt(x * x + y * y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }

        for (Point p : points) {
            System.out.printf("%.2f%n", p.distanceTo());
        }

        if (n > 1) {
            double dist = points[0].distanceTo(points[n - 1]);
            System.out.printf("%.2f%n", dist);
        } else {
            System.out.printf("0.00%n");
        }

        sc.close();
    }
}
