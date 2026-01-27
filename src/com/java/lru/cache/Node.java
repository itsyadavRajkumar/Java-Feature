package com.java.lru.cache;

public class Node {
    int key, val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
