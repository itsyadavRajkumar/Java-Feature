package com.java.stream;

import java.util.Arrays;
import java.util.List;

public class StudentMarksGreaterThan90 {
    public static class Student {
        private String name;
        private double marks;

        public Student(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public double getMarks() {
            return marks;
        }

    }

    public static void main(String[] args) {
        Student student1 = new Student("student1", 79.09);
        Student student2 = new Student("student2", 89.09);
        Student student3 = new Student("student3", 92.09);
        Student student4 = new Student("student4", 69.09);
        Student student5 = new Student("student5", 99.09);

        List<Student> studentList = Arrays.asList(
                student1, student2, student3, student4, student5
        );

        studentList.stream()
                .filter(x->x.getMarks() > 90)
                .map(Student::getName)
                .toList()
                .forEach(System.out::println);
    }
}
