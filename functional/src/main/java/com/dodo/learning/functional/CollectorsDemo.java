package com.dodo.learning.functional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {

        String text = " This is my horse. The horse is white. The horse runs very fast and i love my horse like a white";
        String text2 = " This is my horse";

        Map<String, String> wordsMap = Arrays.stream(text2.split(" "))
                .collect(Collectors.toMap( e -> e, e -> {
                    System.out.println(e);
                    return e;
                }));

        wordsMap.forEach( (k, v) -> {
            System.out.println(k +" "+v);
        });

    }
}
