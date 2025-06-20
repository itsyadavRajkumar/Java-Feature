package com.java.string;

public class StringBuilderOpr {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.append(" World!");
        System.out.println(stringBuilder);
        System.out.println("Length: " + stringBuilder.length());
        Thread thread = new Thread(()-> {
            for (int i = 0; i < 2000; i++) {
                stringBuilder.append('c');
            }
        });
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 2000; i++) {
                stringBuilder.append('f');
            }
        });

//        thread.run();
//        thread1.run();

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println("Length: " + stringBuilder.length());
    }
}
