package com.java.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighestSalariedEmployeeFromAList {
    public static void main(String[] args) {
        Map<String, Integer> employee = new HashMap<>();
        employee.put("Ram", 100);
        employee.put("Ramesh", 110);
        employee.put("Rahul", 109);
        employee.put("Rohit", 200);
        employee.put("Rajkumar", 500);


        employee.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(1)
                .toList()
                .forEach(System.out::println);
    }
}
