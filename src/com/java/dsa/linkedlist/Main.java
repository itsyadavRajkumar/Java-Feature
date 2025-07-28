package com.java.dsa.linkedlist;

public class Main {
    public static void main(String[] args) {
        Node one = new Node();
        one.val = 1;
        one.next = null;

        Node two = new Node();
        two.val = 2;
        two.next = null;

        Node three = new Node();
        three.val = 3;
        three.next = null;

        one.next = two;
        two.next = three;


        Node temp = one;
        while (temp != null) {
            System.out.print(temp.val);
            System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.print("null");

    }
}
