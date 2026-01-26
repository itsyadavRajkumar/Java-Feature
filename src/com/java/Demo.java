package com.java;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int h, e, m, s, c;
        Scanner scanner = new Scanner(System.in);
        h = scanner.nextInt();
        e = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        c = scanner.nextInt();
        int percent = (h + e + m + s + c) / 5;
        String grade = "";
        if (percent < 45) {
            grade = "Fail";
        }
        else if (percent >= 45 && percent <= 60) {
            grade = "D";
        }
        else if (percent > 60 && percent <= 75) {
            grade = "C";
        }
        else if (percent > 75 && percent <= 90) {
            grade = "B";
        }
        else if (percent > 90 && percent <= 100) {
            grade = "A";

        }
        System.out.println(grade);
    }
}
