package com.dodo.learning.functional.optional;

import java.util.Optional;

public class OptionalMain {

    public void sayHello(){
        System.out.println("Hello");
    }

    static void sayBye(){
        System.out.println("Bye");
    }

    public static void main(String[] args) {

        Integer i = 10;
        Optional<Integer> option = Optional.of(i);
        System.out.println(option.get());

        Optional<Integer> temp = Optional.empty();

        System.out.println(temp.orElse(0));

        new OptionalMain().sayHello();
        OptionalMain.sayBye();


    }
}
