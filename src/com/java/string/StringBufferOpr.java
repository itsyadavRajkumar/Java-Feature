package com.java.string;

public class StringBufferOpr {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer stringBuffer = new StringBuffer("Hello");
        stringBuffer.append(" Worlds!");
        System.out.println(stringBuffer);

        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 2000; ++i) {
                stringBuffer.append('c');
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                stringBuffer.append('f');
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Length: " + stringBuffer.length());
    }
}
