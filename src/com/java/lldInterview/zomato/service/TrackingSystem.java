package com.java.lldInterview.zomato.service;

import com.java.lldInterview.zomato.model.Location;

public class TrackingSystem {
    public double estimateETA(Location source,
                              Location destination) {
        double distance = source.distanceTo(destination);
        return distance * 2;
    }
}
