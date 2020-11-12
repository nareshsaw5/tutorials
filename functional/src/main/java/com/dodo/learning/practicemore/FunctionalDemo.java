package com.dodo.learning.practicemore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalDemo {

    public static void main(String[] args) {

        Collector<Integer, ArrayList<Integer>, ArrayList<Integer>> collector = Collector
                .of(ArrayList::new, (list, n) -> {
                    list.add(n);
                    },(list1, list2) -> {
                    list1.addAll(list2);
                    return list2;
                }, Collector.Characteristics.IDENTITY_FINISH);

        ArrayList<Integer> collectedData = List.of(6, 2, 3, 4, 5, 1).stream().sorted().collect(collector);
        collectedData.forEach(System.out::println);

        Collector.of(ArrayList::new, // supplier, takes nothing, return new Arraylist
                (accumulator, element) -> accumulator.add(element), // accumulator
                (list1, list2) -> list1, // combiner
                Collector.Characteristics.IDENTITY_FINISH // finisher/characteristics
        );
        System.out.println("+++++++++++++++++++");
        List.of(100, 200, 300).stream().collect(collector).forEach(System.out::println);

        System.out.println("+++++++++++++++++++");


        Map.of( 1, "Naresh", 2, "Dinesh").entrySet().stream()
                .collect( Collectors.toList()).forEach( (entry) -> {
            System.out.println(entry.getKey() +" "+entry.getValue());
        });

        Map<String, String> listToMap = List.of("C", "F", "B","A", "E","D").stream().collect(Collectors.toMap(k -> k, v -> v));
        listToMap.forEach( (k, v) -> {
            System.out.println(k +" "+v);
        });
        System.out.println("+++++++++++++++++++");

        Map<String, String> sortedMap = listToMap.entrySet().stream().sorted( (e1, e2) -> e2.getValue().compareTo(e1.getValue()) )
                .collect(Collectors.toMap(k -> k.getValue(), v -> v.getValue()));
        sortedMap.forEach( (k,v) -> System.out.println(k +""+v));

        System.out.println("+++++++++++++++++++");
    }
}

