package com.java.lambdasExpression;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExp {
    /*
    lambda expression is anonymous function(no name, no return type, no access modifier)
    apply on the only functional interface
     */
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(2));

        Predicate<String> startWithR = x -> x.toLowerCase().startsWith("r");
        Predicate<String> endWithV = x -> x.endsWith("v");
        System.out.println(startWithR.test("RajkumarYadav"));
        System.out.println(endWithV.test("Yadav"));
        Predicate<String> and = startWithR.and(endWithV);
        System.out.println(and.test("Rajiv"));

        Function<Integer, Integer> square = x -> x * x;
        System.out.println(square.apply(5));
    }

    private static void solve() {
        String str = "rajkumar";
//        str.toCharArray().
    }
}
