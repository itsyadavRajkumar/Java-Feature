package com.java.lldInterview.model;

public class Customer {
    private String name;
    private String id;
    private Location location;

    public Customer(String name, String id, Location location) {
        this.name = name;
        this.id = id;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }
}
