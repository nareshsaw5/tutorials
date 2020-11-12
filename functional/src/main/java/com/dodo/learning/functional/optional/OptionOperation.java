package com.dodo.learning.functional.optional;

import java.util.Optional;

public class OptionOperation {

    public static void main(String[] args) {
        Optional<Integer> optional = Optional.of(10);
        System.out.println(optional.get());

        Optional<Integer> map = optional.map((val) -> 20);
        System.out.println(map.get());

        Optional<Integer> filter = optional.filter((val) -> val > 5);
        System.out.println(filter.get());

        Optional op = Optional.empty().or( () -> Optional.of("New Value "));
        System.out.println(op);


    }
}
