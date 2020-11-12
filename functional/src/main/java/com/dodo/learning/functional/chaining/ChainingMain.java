package com.dodo.learning.functional.chaining;

import java.util.function.Function;

public class ChainingMain {

    public static void main(String[] args) {

        Consumer<String> c1  = (s) -> System.out.println(s);
        Consumer c2 = (s) -> System.out.println(s);
        //c1.accept("Hello");
        //c2.accept("Naresh");

        Consumer<String> c3 = (c) -> {
            c1.accept(c);
            c2.accept(c);
        };


        //c3.accept("Bob");

       // Consumer c4 = c1.acceptAndReturn(null);
        //c4.accept("Suresh");

        // com.dodo.learning.designpattern.functional chaining
        Function<Integer, Integer> function = s -> s + 2;
        Function<Integer, Integer> function2 = s -> s * 2;
        Function<Integer, Integer> function3 = function.andThen(function2);
        System.out.println(function3.apply(10));



    }
}
