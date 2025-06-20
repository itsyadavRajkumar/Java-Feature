package com.java.claases;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
//    private int x;
//    private int y;
//
//    public int getX() {
//        return x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }

    public static void main(String[] args) {
        MyApplication myApplication = new MobileOtp();
        myApplication.generateOtp();
        System.out.println(MyApplication.x);
        System.out.println(myApplication.generateOtp());
        MobileOtp mobileOtp = new MobileOtp();


        FunInterface add = (x, y) -> x - y;

        FunInterface sub = (x, y) -> x * y;
        System.out.println(sub.calculate(3, 5));

        System.out.println(add.calculate(3, 5));


        String name = "hello";
//        name.chars()
        List<String> list = Arrays.asList("rajkumar", "sandeep", "rajkumar");

        list.forEach(x->System.out.println(x));
//        list.forEach(x->System.out::println);

//        list.stream().sorted(x-> Collectors.);

        Predicate<Integer> predicate = (x) -> x % 2 == 0;
        System.out.println(predicate.test(3));
    }


}

