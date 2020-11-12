package com.dodo.learning.functional.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class CollectorDemo {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // A Collector has supplier, accumulator, combiner, characteristic
        Collector<Integer, List<Integer>, List<Integer>> collector = Collector.of(ArrayList::new, // supplier
                (list, e) -> list.add(e), // accumulator
                (list1, list2) -> { // combiner(BiFunction)
                    list1.addAll(list2);
                    return list1;
                },Collector.Characteristics.IDENTITY_FINISH
        );

        List<Integer> evens = numbers.stream().filter( (e) -> e%2 ==0).collect(collector);
        System.out.println(evens);

    }
}
