package com.dodo.learning.functional.collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollectorDemo {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1);

        Collector<Integer, List<Integer>, List<Integer>> collector  = Collector.of(ArrayList::new, // supplier
                (list, e) -> list.add(e),
                (list1, list2) -> { list1.addAll(list2); return list1;},//BiFunction
                Collector.Characteristics.IDENTITY_FINISH
                );

        List<Integer> evens = numbers.stream().filter( (e) -> e%2 ==0).collect(collector);
        System.out.println(evens);


        Collector<Integer, List<Integer>, List<Integer>> sortedListCollector = Collector.of(
                ArrayList::new,
                (list, e) -> list.add(e),
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                },
                (list3) -> { Collections.sort(list3); return  list3; },
                Collector.Characteristics.UNORDERED);

        List<Integer> sortedList = numbers.stream().collect(sortedListCollector);
        System.out.println(sortedList);


    }
}
