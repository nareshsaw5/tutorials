package com.dodo.tutorials.datastructure.map;

import java.util.*;

public class MapMain {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 3);
        map.put("C", 2);
        MapToList(map);

    }

    static void MapToList(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> values = new ArrayList<>((map.entrySet()));
        Collections.sort(values, (o1, o2) -> o1.getValue().compareTo( o2.getValue() ));
        System.out.println(values);
    }
}
