package com.dodo.learning.stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class NumericStream {

    public static void main(String[] args) {
        IntStream intS = IntStream.of(1, 2, 32, 4, 5, 6, 6, 754);
        double average = intS.average().getAsDouble();
        System.out.println(average);

        double doubleS = DoubleStream.of(2, 2, 3, 5, 5, 6, 7, 7, 7, 8, 8).average().getAsDouble();
        System.out.println(doubleS);

        //List<Integer> list = intS.boxed().collect(Collectors.toList());
        // Map<Integer, Integer> map = list.stream().collect( Collectors.toMap( n -> n, v -> v));

/*

        map.entrySet()
                .stream()
                //.sorted()
                .forEach( (entry) -> System.out.println(entry.getKey()));
*/

    }
}
