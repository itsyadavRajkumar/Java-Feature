package com.java.lldInterview.model;

public class DeliveryPartner {
    private String id;
    private String name;
    private Location location;
    private boolean available;

    public DeliveryPartner(String id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.available = true;
    }

    public void assign() {
        this.available = false;
    }

    public boolean isAvailable() {
        return available;
    }

    public void release() {
        this.available = true;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
