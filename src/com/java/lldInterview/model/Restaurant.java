package com.java.lldInterview.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String id;
    private String name;
    private List<Menu> menu;
    private Location location;

    public Restaurant(String id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.menu = new ArrayList<>();
    }

    public void addMenuItem(Menu item) {
        menu.add(item);
    }

    public Location getLocation() {
        return location;
    }

    public List<Menu> getMenu() {
        return menu;
    }
}
