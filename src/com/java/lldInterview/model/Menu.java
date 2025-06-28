package com.java.lldInterview.model;

public class Menu {
    private String name;
    private double prize;

    public Menu(String name, double prize) {
        this.name = name;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public double getPrize() {
        return prize;
    }
}
