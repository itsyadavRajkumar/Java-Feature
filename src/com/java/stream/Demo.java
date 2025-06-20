package com.java.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("rajkumar", "rajkumaR");
        Map<Object, Long> string = str.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        Map<Character, Long> list = str.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        List<Integer> list1 = Arrays.asList(11121213, 2, 1, 3, 2, 3, 121, 21, 1221, 22, 1, 33, 232, 443, 5);
//        list1.stream().sorted((x, y) -> y - x).forEach(System.out::println);
        Integer max = list1.stream()
                .max(Comparator.naturalOrder()).get();

        Integer min = list1.stream()
                .min(Comparator.naturalOrder()).get();

//        Integer max = list1.stream().collect(Collectors.maxBy((x, y) -> x - y)).get();
        System.out.println("max: " + max);
        System.out.println("min: " + min);

        Map<Integer, Long> collect = list1
                .stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println("hash: " + collect);

        Map<String, Long> collect1 = str.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));


        Map<Character, Long> list2 = str
                .stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(list);
        System.out.println("List2" + list2);

        System.out.println("String Hash: " + collect1);

        List<String> list3 = Arrays.asList("Hello", "My", "Name", "Raj", "Hello", "Name", "Hello");

        Map<String, Long> collect2 = list3.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//        List<Map.Entry<String, Long>> collect3 = collect2.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
//        System.out.println(collect3);

        collect2.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);


        List<Integer> list4 = Arrays.asList(1, 2, 31, 2, 1, 2, 3, 4, 2);
        list4.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);


        list3.stream()
                .map(String::toUpperCase)
                .toList()
                .forEach(System.out::println);

        String sentence = new String("this is the best example!");

        Arrays.stream(sentence.split(" "))
                .map(s -> s.equals("best") ? "average" : s)
                .toList()
                .forEach(System.out::println);


        String list5 = sentence.chars()
                .mapToObj(c -> String.valueOf(c == ' ' ? '_' : (char) c))
                .collect(Collectors.joining());

        System.out.println(list5);

        String collect3 = Arrays.stream(sentence.split("_"))
                .collect(Collectors.joining());
        System.out.println(collect3);

        Map<Character, Long> collect4 = collect3.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        collect4.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
        System.out.println(collect4);


//        String[] newStr = {"Rajkumar", "Yadav", "ThIs", "SiDe", "Rajkumar", "side", "this"};
//        List<Map.Entry<String, Long>> collect5 = Arrays.stream(newStr)
////                .map(s -> s.length() > 4 ? s.toUpperCase() : s.toLowerCase())
//                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
////                        .entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
//                .entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
//        System.out.println(collect5);
//

//        find the frequency of string from given sentence and sort them in assecending order based on frequency

        String[] newStr = {"Rajkumar", "Yadav", "ThIs", "SiDe", "Rajkumar", "side", "this"};
        List<Map.Entry<String, Long>> collect5 = Arrays.stream(newStr)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
        System.out.println("Collect5: " + collect5);


        String s1 = "Hello";
        String s2 = s1.toLowerCase();
        System.out.println("S1 : " + s1 + " S2 : " + s2);

        StringBuilder s3 = new StringBuilder("Hello");
        System.out.println(s3.toString().toLowerCase());


//        TestConstrutor testConstrutor= new TestConstrutor(2);
        String name = "Rajkumar_Yadav_Yadav_Ravi";

        List<Map.Entry<Integer, Long>> list6 = name.chars()
                .mapToObj(x -> x)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .toList();

        list6.forEach(entry ->
                System.out.println("'" + (char) (int) entry.getKey() + "' -> " + entry.getValue()));


        name.chars()
                .mapToObj(x -> x)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .skip(3).toList().forEach(x -> System.out.println((char) (int) x.getKey() + ": " + x.getValue()));


        List<Map.Entry<Integer, Long>> list7 = name.chars().mapToObj(x -> x)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .skip(3).limit(1).toList();

        System.out.println(list7);
        System.out.println((char) (int) list7.get(0).getKey() + ":" + list7.get(0).getValue());

        int[] post = {1, 22, 32, 42, 52, 53, 63, 44};
        int[] arr = {post.length - 1};
//        Arrays.stream(arr).forEach(x->System.out.println(x));
        System.out.println(arr[0]);




        List<String> strr = Arrays.asList("abc", "xyz", "abc", "xyz", "cde", "Rajkumar", "Rajkumar", "Rajkumar", "Rajkumar", "Yadav");
        List<Map.Entry<String, Long>> sorted = strr.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).toList();

        System.out.println(sorted);

        String opr = "rajkumaryadavranepur";
        List<Map.Entry<Character, Long>> collect6 = opr.chars()
                .mapToObj(x -> (char)x)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();

        System.out.println(collect6);
    }

}