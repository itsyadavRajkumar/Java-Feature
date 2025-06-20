package com.java.string;

public class StringOpr {
    public static void main(String[] args) {
        String str = "Hello";
        String concat = str.concat(" World!");
        System.out.println("Str: " + str + "\nconcat: " + concat);
        str = concat;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
//                str.concat("C");
            }
        });
    }
}
