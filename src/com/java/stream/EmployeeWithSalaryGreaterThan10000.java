package com.java.stream;

import java.util.Arrays;
import java.util.List;

public class EmployeeWithSalaryGreaterThan10000 {

    static class Employee {
        private String id;
        private double salary;

        public Employee(String id, double salary) {
            this.id = id;
            this.salary = salary;
        }

        public String getId() {
            return id;
        }

        public double getSalary() {
            return salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("employee1", 12000),
                new Employee("employee2", 9000),
                new Employee("employee3", 11000),
                new Employee("employee4", 10000),
                new Employee("employee5", 18000),
                new Employee("employee6", 2000),
                new Employee("employee7", 10000.9)
        );
        employees.stream()
                .filter(x->x.getSalary() > 10000)
                .map(Employee::getId)
                .forEach(System.out::println);
    }
}
