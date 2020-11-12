package com.dodo.learning.functional.collection_functional_way;

import java.util.*;
import java.util.stream.Collectors;

public class MapDemo {

    public static void main(String[] args) {
        Map<Integer, String> cities = Map.of(22, "Mumbai", 33, "Kolkata", 11, "New Delhi", 44, "Chennai", 55, "Hyderabad", 66, "Bengaluru");


        // older way of traversal
        for(Map.Entry<Integer, String> city: cities.entrySet()){
            System.out.println(city.getKey() + " "+city.getValue());
        }

        System.out.println("_______________________");

        // newer way
        cities.forEach( (k, v) -> System.out.println(k + " "+v));

        System.out.println("_______________________");

        // all the operation on map has to performed on entrySet
        List<Map.Entry<Integer, String>> filteredCities = cities.entrySet().stream()
                .filter( (entry) -> entry.getKey() > 50)
                .collect(Collectors.toList());

        filteredCities.stream().map( (entry -> entry.getValue() + " : "+entry.getValue())).forEach(System.out::println);
        System.out.println("_______________________");

        // collect into a filtered map

        Map<Integer, String> filteredMCities = cities.entrySet().stream().filter((entry) -> entry.getValue().contains("Mu"))
                .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));

        filteredMCities.entrySet().forEach(System.out::println);
        System.out.println("_______________________");

        // get the list of the names
        List<String> cityNames = cities.entrySet().stream().map((entry -> entry.getValue())).collect(Collectors.toList());
        cityNames.forEach(System.out::println);
        System.out.println("_______________________");

        // get all the names of the cities in a string with comma separated
        String commaSepartedCities = cities.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.joining(", "));
        System.out.println(commaSepartedCities);

        // sorting

        // sorting of the map only happens on Map.Entry<K, V>

        cities.entrySet().stream().forEach(System.out::println);
        cities.entrySet().stream().map( (entry) -> entry.getKey() +" : "+entry.getValue()).forEach(System.out::println);









    }
}
