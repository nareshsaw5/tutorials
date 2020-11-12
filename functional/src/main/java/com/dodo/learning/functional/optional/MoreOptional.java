package com.dodo.learning.functional.optional;

import java.util.Optional;

public class MoreOptional {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Naresh");

        //ifPresent
        optional.ifPresent( val -> System.out.println("This is a "+val));

       //or
        optional.stream().forEach(System.out::println);


    }
}
