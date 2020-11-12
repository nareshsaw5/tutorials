package com.dodo.learning.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculations {

    public static void main(String[] args) {

        List<Integer> list = IntStream.of(1,2,2,3,4,5,56,7,7,7,8,89)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list);

        int first = IntStream.of(1,2,2,3,4,5,56,7,7,7,8,89).findFirst().getAsInt();
        System.out.println(first);

    }
}
