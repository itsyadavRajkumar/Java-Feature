package com.java.constructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class TestConstrutor {
    private TestConstrutor() {
        System.out.println("private constructor!");
    }

    public TestConstrutor(int x) {
        System.out.println("this is public constructor" + x);

        String[] ar = {"as", "aad"};
        main(ar);

        for (String erd : Arrays.asList("erd","jjk","kik")) {
            System.out.println(erd);
        }

//        ArrayList

    }

    public static void main(String[] ar) {
        System.out.println(ar.toString());
        String str1 = new String("This is the demo for the private constructor");
        Arrays.stream(str1.split(" "))
//                .flatMap()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        TestConstrutor testConstrutor = new TestConstrutor();
        TestConstrutor testConstrutor1 = new TestConstrutor();
    }
}
