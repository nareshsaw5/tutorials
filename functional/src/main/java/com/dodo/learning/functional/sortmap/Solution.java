package com.dodo.learning.functional.sortmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        Map<String, Integer> maps = new HashMap<>();
        maps.put("Bob", 30);
        maps.put("Mary", 20);
        maps.put("John", 10);
        maps.put("Mark", 40);
        // sort in order of their age

        Map<String, Integer> sortedMap =
                maps.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new ));

        sortedMap.forEach( (k,v) -> System.out.println(k +" "+v));



    }
}
