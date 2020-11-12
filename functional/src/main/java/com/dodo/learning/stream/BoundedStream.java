package com.dodo.learning.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoundedStream {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.entrySet().stream().forEach(System.out::println);

        map.values().stream().forEach(System.out::println);
        map.keySet().stream().forEach(System.out::println);

        List.of(2,3,5,55,5,56,56,6);

        // String stream


    }
}
