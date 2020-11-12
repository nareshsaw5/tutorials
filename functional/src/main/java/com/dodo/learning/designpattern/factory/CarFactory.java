package com.dodo.learning.designpattern.factory;

import java.util.function.Supplier;

public class CarFactory {

    /**
     * This is factory method
     * @param numberOfRiders
     * @return
     */
    public static Car getCar(int numberOfRiders) {
        Supplier<Car> supplier;

        if (numberOfRiders < 5) {
            supplier = () -> new HatchBack();
        } else if (numberOfRiders > 5) {
            supplier = () -> new Suv();
        } else {
            supplier = () -> new Sedan();
        }
        return supplier.get();
    }
}
