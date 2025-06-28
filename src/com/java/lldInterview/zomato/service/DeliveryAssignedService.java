package com.java.lldInterview.zomato.service;

import com.java.lldInterview.zomato.model.DeliveryPartner;
import com.java.lldInterview.zomato.model.Location;

import java.util.List;

public class DeliveryAssignedService {
    public DeliveryPartner findNearest(List<DeliveryPartner> partners,
                                       Location pickupLocation) {
        DeliveryPartner nearest = null;
        double minDistance = Double.MAX_VALUE;
        for (DeliveryPartner partner:partners) {
            if (partner.isAvailable()) {
                double distance = partner.getLocation()
                        .distanceTo(pickupLocation);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearest = partner;
                }
            }
        }
        return nearest;
    }
}
