package com.dodo.learning.functional.currying;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CurryingDemo {

    public static void main(String[] args) {
        // currying is a technic where each a function with multi-parameter is broken into multi-function
        //each function takes single param and return value
        // in the below example, instead of sending two parameters to single function,
        // we broke function into two function, passing single parameter to each one
        Function<Integer, Function<Integer, Integer>> fun = (u) -> (v) -> u + v ;
        Integer sum = fun.apply(5).apply(3);
        System.out.println(sum);

        BiFunction<Integer, String, Person> fun2 = (id, name) -> new Person(id, name);
        Person p = fun2.apply(10, "Naresh");
        System.out.println(p);
    }
}

class Person {

    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
