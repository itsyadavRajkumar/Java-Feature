package com.java.lldInterview.zomato.model;

import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private Restaurant restaurant;
    private List<Menu> items;
    private DeliveryPartner deliveryPartner;
    private OrderStatus orderStatus;

    public Order(String id, Customer customer, Restaurant restaurant, List<Menu> items) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = items;
        this.orderStatus = OrderStatus.PLACED;
    }

    public void assignDeliveryPartner(DeliveryPartner deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
        this.orderStatus = OrderStatus.ASSIGNED;
        deliveryPartner.assign();
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
