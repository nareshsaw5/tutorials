package com.dodo.learning.designpattern.factory;

public class CarFactoryDemo {

    public static void main(String[] args) {
        Car car =  CarFactory.getCar(4);
        System.out.println(car.type() +" "+car.seats());

        car =  CarFactory.getCar(6);
        System.out.println(car.type()+ " "+car.seats());
    }
}
