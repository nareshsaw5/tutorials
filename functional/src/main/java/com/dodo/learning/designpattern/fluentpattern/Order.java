package com.dodo.learning.designpattern.fluentpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Order {

    private List<String> cart = new ArrayList<>();
    private String address = "";

    public Order() {
    }

    public Order(List<String> cart) {
        this.cart = cart;
    }

    public Order(List<String> cart, String address) {
        this.cart = cart;
        this.address = address;
    }

    public Order add(String item){
        this.cart.add(item);
        return new Order(this.cart);
    }

    public Order setDeliveryAddress(String address){
        return new Order(this.cart, address);
    }

    public static void place(Function<Order, Order> function){
        Order order = new Order();
        function.apply(order);
        System.out.println("Order placed");
        System.out.println("Order placed with cart size "+order.cart.size());
    }
}
