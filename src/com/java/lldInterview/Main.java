package com.java.lldInterview;

import com.java.lldInterview.model.*;
import com.java.lldInterview.service.DeliveryAssignedService;
import com.java.lldInterview.service.TrackingSystem;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new
                Customer("Raj", "C1",
                new Location(10, 10));

        Restaurant r1 = new Restaurant("R1", "BurgerHub",
                new Location(12, 12));

        r1.addMenuItem(new Menu("Burger", 150));
        r1.addMenuItem(new Menu("pizza", 170));

        DeliveryPartner p1 = new DeliveryPartner("DP1", "Ravi",
                new Location(11, 11));
        DeliveryPartner p2 = new DeliveryPartner("DP2", "Rahul",
                new Location(14, 14));

        List<DeliveryPartner> partners = Arrays.asList(p1, p2);

        List<Menu> menusItem = Arrays.asList(r1.getMenu().get(0), r1.getMenu().get(1));

        Order order = new Order("O1", c1, r1, menusItem);

        DeliveryAssignedService assignedService = new DeliveryAssignedService();
        DeliveryPartner assigned = assignedService.findNearest(partners, r1.getLocation());

        if (assigned != null) {
            order.assignDeliveryPartner(assigned);
            System.out.println("Order Assigned to: " + assigned.getName());


        }

        TrackingSystem trackingSystem = new TrackingSystem();
        double eta = trackingSystem.estimateETA(r1.getLocation(), c1.getLocation());

        System.out.println("Estimated ETA: " + eta + "Minutes");

    }
}
