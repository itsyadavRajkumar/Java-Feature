package com.java.map;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class MyConcurrentHashMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private volatile Node<K, V>[] table;
    private volatile ReentrantLock[] locks;
    private volatile int size = 0;


    static class Node<K, V> {
        final K key;
        volatile V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyConcurrentHashMap(int capcity) {
        this.table = (Node<K, V>[]) new Node[capcity];
        this.locks = new ReentrantLock[capcity];
        for (int i = 0; i < capcity; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    public MyConcurrentHashMap() {
        this(16);
    }

    private int hash(Object key, int capcity) {
        int h = key.hashCode();
        return (h ^ (h >>> 16)) & (capcity - 1); // Spread bits and mod
    }

    public V get(K key) {
        Objects.requireNonNull(key);
        int index = hash(key, table.length);
        Node<K, V> head = table[index];
        for (Node<K, V> curr = head; curr != null; curr = curr.next) {
            if (curr.key.equals(key)) return curr.value;
        }
        return null;
    }

    public void put(K key, V value) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(value);

        int index = hash(key, table.length);
        ReentrantLock lock = locks[index];
        lock.lock();
        try {
            Node<K, V> head = table[index];
            for (Node<K, V> curr = head; curr != null; curr = curr.next) {
                if (curr.key.equals(key)) {
                    curr.value = value;
                    return;
                }
            }
            Node<K, V> newNode = new Node<>(key, value, head);
            table[index] = newNode;
            size++;

            if ((float) size / table.length > LOAD_FACTOR) {
                resize();
            }
        } finally {
            lock.unlock();
        }
    }

    private synchronized void resize() {
        if ((float)size / table.length <= LOAD_FACTOR) return;

        int newCapcity = table.length * 2;

        Node<K, V>[] oldTable = table;
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newCapcity];
        ReentrantLock[] newLocks = new ReentrantLock[newCapcity];

        for (int i = 0; i < newCapcity; i++) {
            newLocks[i] = new ReentrantLock();
        }

        for (int i = 0; i < oldTable.length; i++) {
            Node<K, V> head = oldTable[i];
            while (head != null) {
                Node<K, V> next = head.next;
                int newIndex = hash(head.key, newCapcity);
                head.next = newTable[newIndex];
                newTable[newIndex] = head;
                head = next;
            }
        }
        table = newTable;
        locks = newLocks;
    }

    public V remove(K key) {
        Objects.requireNonNull(key);
        int index = hash(key, table.length);
        ReentrantLock lock = locks[index];
        lock.lock();
        try {
            Node<K, V> curr = table[index];
            Node<K, V> prev = null;
            while (curr != null) {
                if (curr.key.equals(key)) {
                    if (prev == null) {
                        table[index] = curr.next;
                    } else {
                        prev.next = curr.next;
                    }
                    size--;
                    return curr.value;
                }
                prev = curr;
                curr = curr.next;
            }
            return null;
        } finally {
            lock.unlock();
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }










    public static void main(String[] args) throws InterruptedException {
        MyConcurrentHashMap<String, String> map = new MyConcurrentHashMap<>();

        // 🔹 Test 1: Single-threaded put & get
        map.put("A", "Apple");
        map.put("B", "Banana");
        map.put("C", "Cherry");

        System.out.println("Get A: " + map.get("A")); // Apple
        System.out.println("Get B: " + map.get("B")); // Banana
        System.out.println("Get C: " + map.get("C")); // Cherry

        // 🔹 Test 2: Remove
        map.remove("B");
        System.out.println("Get B after remove: " + map.get("B")); // null

        // 🔹 Test 3: Concurrent writes
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                map.put("T1-" + i, "Data-" + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 50; i < 100; i++) {
                map.put("T2-" + i, "Data-" + i);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // 🔹 Test 4: Concurrent reads
        System.out.println("T1-10: " + map.get("T1-10")); // should print Data-10
        System.out.println("T2-90: " + map.get("T2-90")); // should print Data-90

        // 🔹 Final Size Check
        System.out.println("Final Size: " + map.size()); // Should be 101 (3 put - 1 remove + 98 thread inserts)
    }

}
