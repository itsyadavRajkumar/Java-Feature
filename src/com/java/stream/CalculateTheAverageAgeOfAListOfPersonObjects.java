package com.java.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateTheAverageAgeOfAListOfPersonObjects {

    public static class Person {
        private String name;
        private double age;

        public Person(String name, double age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public double getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("Rajkumar", 26.8);
        Person p2 = new Person("Rahul", 28.9);
        Person p3 = new Person("Sandeep", 27.8);
        Person p4 = new Person("Deepak", 26);

        List<Person> personList = Arrays.asList(p1, p2, p3, p4);

//        1st approach
        Double avgAge = personList.stream()
                .collect(Collectors.averagingDouble(Person::getAge));

        System.out.println(avgAge);


//        2nd approach
        double avgAgePers = personList.stream()
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0);

        System.out.println(avgAgePers);
    }
}
