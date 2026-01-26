package com.java.opps.abstraction;

public interface Demo {
    int add(int x, int y);
    public abstract int sub(int x, int y);

    static int multi(int x, int y) {
        return x * y;
    }

    default int div(int x, int y) {
        int divi = -1;
        try {
            divi = x / y;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("divide complete!");
        }
        return divi;
    }
}
