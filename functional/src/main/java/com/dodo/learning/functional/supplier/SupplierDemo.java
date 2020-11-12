package com.dodo.learning.functional.supplier;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Double> supplier = () -> new Random().nextDouble();
        System.out.println(supplier.get());
    }
}
