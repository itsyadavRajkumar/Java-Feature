package com.java.interviewQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private int id;
    private String name;
    private String className;
    private double marks;

    // Constructor
    public Student(int id, String name, String className, double marks) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.marks = marks;
    }


    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }


    // Method to display student details
    public void displayStudentInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Class: " + className);
        System.out.println("Marks: " + marks);
        System.out.println();
    }
    public static void main(String[] args){
        Student student1 = new Student(101, "John Doe", "10th Grade", 100);
        Student student2 = new Student(102, "Div", "10th Grade", 95);
        Student student3 = new Student(103, "stu3", "10th Grade", 80);
        Student student4 = new Student(104, "stu4", "9th Grade", 85.5);
        Student student5 = new Student(105, "Div", "9th Grade", 85.5);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        for(int i=0;i<students.size();i++){
            students.get(i).displayStudentInfo();

        }

        System.out.println(students.stream().collect(Collectors.groupingBy(Student::getClassName, Collectors.averagingDouble(Student::getMarks))));
//        Double list1 = students.stream().filter(s -> s.getClassName().equals("10th Grade")).map(Student::getMarks).collect(Collectors.averagingDouble(value -> value));
//        Double tenthGrade = students.stream().filter(s -> s.getClassName().equals("10th Grade")).collect(Collectors.averagingDouble(Student::getMarks));
//        Double ninethGrade = students.stream().filter(s -> s.getClassName().equals("9th Grade")).collect(Collectors.averagingDouble(Student::getMarks));
//        System.out.println(tenthGrade);
//        System.out.println(ninethGrade);
//        System.out.println(list1);


        Map<String, Double> avg = students.stream()
                .collect(Collectors.groupingBy(x -> x.getClassName(), Collectors.averagingDouble(x -> x.getMarks())));

        System.out.println(avg);
    }
}

//Select dept, AVG(Salary) as Avg_salary from emp Group by Dept;