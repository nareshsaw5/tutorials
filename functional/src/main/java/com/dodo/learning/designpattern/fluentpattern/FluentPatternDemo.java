package com.dodo.learning.designpattern.fluentpattern;

public class FluentPatternDemo {

    public static void main(String[] args) {
        Order.place((order) -> order.add("Shoe").add("Jacket").setDeliveryAddress("675, Java Drive"));
    }

}
