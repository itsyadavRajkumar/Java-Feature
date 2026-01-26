package com.java.inheritence;

public class Main {
    public static void main(String[] args) {
        C ob = new C();
        System.out.println(ob.add(3, 4));
        System.out.println(ob.sub(5, 2));

        C1 c1 = new C1();
        System.out.println(c1.add(5, 3));
        System.out.println(c1.multiply(5,3));
    }
}
