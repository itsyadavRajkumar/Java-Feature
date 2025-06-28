package com.java.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Rajkumar", 100.9, "IT");
        Employee employee2 = new Employee(2, "Ravi", 101.9, "Technical");
        Employee employee3 = new Employee(3, "Rahul", 103.9, "HR");
        Employee employee4 = new Employee(4, "Nandlal", 107.9, "IT");
        Employee employee5 = new Employee(5, "Sarad", 104.9, "IT");

        Optional<Employee> max = Arrays.asList(employee1, employee2, employee3, employee4, employee5)
                .stream()
                .max((x, y) -> Double.compare(x.getSalary(), y.getSalary()));
        max.ifPresentOrElse(
                e-> System.out.println(e.getId() + ": " + e.getName() + " : " + e.getSalary()),
                () -> System.out.println("Not Found!")
                );
    }
}
