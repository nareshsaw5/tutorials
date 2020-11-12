package com.dodo.learning.practicemore.bifunction;

import java.util.List;
import java.util.function.BiFunction;

public class BiFunctionDemo {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> sumFn = (n1, n2) -> n1+n2;
        System.out.println(sumFn.apply(5,10));



    }
}
