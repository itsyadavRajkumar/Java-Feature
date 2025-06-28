package com.java.lldInterview.service;

import com.java.lldInterview.model.Location;

public class TrackingSystem {
    public double estimateETA(Location source,
                              Location destination) {
        double distance = source.distanceTo(destination);
        return distance * 2;
    }
}
