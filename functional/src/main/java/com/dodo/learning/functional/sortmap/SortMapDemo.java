package com.dodo.learning.functional.sortmap;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("e", 1, "d", 2, "c",3, "a", 5);

        // sort by key
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted( Map.Entry.comparingByKey())
                .collect( Collectors.toMap( Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        sortedMap.forEach( (k, v) -> System.out.println(k +" "+v));
        System.out.println("++++++++++++++++");


        //sort by value
        // make sure you use the merge function and Supplier at the end so that the insert order is maintained
        Map<String, Integer> sortedByValue = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        sortedByValue.forEach( (k, v) -> System.out.println(k +": "+v));
        System.out.println("++++++++++++++++");

        // sort by reverse order of key
        Map<String, Integer> sortedMapInReverseOrde  = map.entrySet().stream()
                .sorted( Map.Entry.comparingByValue( Comparator.reverseOrder()))
                .collect( Collectors.toMap( Map.Entry::getKey, Map.Entry::getValue, (oldValue, NewValue) -> oldValue, LinkedHashMap::new));

        sortedMapInReverseOrde.forEach( (k, v) -> System.out.println(k +":"+v));
        System.out.println("++++++++++++++++");

        // sort in reverse order by key
        Map<String, Integer> sortByKeyInRerverORder = map.entrySet().stream()
                .sorted( Map.Entry.comparingByKey( Comparator.reverseOrder()))
                .collect( Collectors.toMap( Map.Entry::getKey, Map.Entry::getValue, (x, y) -> x, LinkedHashMap::new));

        sortByKeyInRerverORder.forEach( (k, v) -> System.out.println(k +":"+v));


    }
}
