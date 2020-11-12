package com.dodo.learning.designpattern.builder;

public class BuilderMain {

    public static void main(String[] args) {
        MobileBuilder builder = new MobileBuilder();
        Mobile myMobile = builder.with( (myBuilder) -> {
            myBuilder.ram = 4;
            myBuilder.battery = 4000;
            myBuilder.processor = "A12 Bionic";
        }).createMobile();

        System.out.println(myMobile);
    }
}
