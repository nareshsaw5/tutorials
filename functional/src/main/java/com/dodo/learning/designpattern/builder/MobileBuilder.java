package com.dodo.learning.designpattern.builder;

import java.util.function.Consumer;

public class MobileBuilder {

    int ram, storage, battery, camera;
    String processor;
    double screenSize;

    public MobileBuilder with(Consumer<MobileBuilder> consumer) {
        consumer.accept(this);
        return this;
    }

    public Mobile createMobile() {
        return new Mobile(this);
    }

}
