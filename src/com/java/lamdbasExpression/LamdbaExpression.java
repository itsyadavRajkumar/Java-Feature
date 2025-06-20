package com.java.lamdbasExpression;

import java.util.function.Predicate;

public class LamdbaExpression {

    private static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadClass());
        t1.run();

        Thread t2 = new Thread(() -> {
            System.out.println("Hello World! -> lambda Expression");
        });
        t2.run();


        MathOperation sumOperation = (x, y) -> {
            return x + y;
        };
        MathOperation subOperation = (x, y) -> x - y;
        System.out.println(sumOperation.operate(2, 4));
        System.out.println(subOperation.operate(2, 4));

        SumOperation sumOperation1 = new SumOperation();
        System.out.println(sumOperation1.operate(22, 55));

        Predicate<Integer> predicate = (x) -> x % 2 == 0;
        System.out.println(predicate.test(4));


        System.out.println(fib(2));
    }
}
