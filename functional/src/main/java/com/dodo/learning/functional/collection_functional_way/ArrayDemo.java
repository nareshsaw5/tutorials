package com.dodo.learning.functional.collection_functional_way;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArrayDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,5, 1,2,4,4,5,5,6,6,6);
        System.out.println(list);

        List<Integer> sorted  = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);

        List<Integer> reverseSorted  = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseSorted);

        Optional<Integer> maxOptional  = list.stream().max( (v1, v2)-> v1.compareTo(v2));
        System.out.println(maxOptional.get());

        Optional<Integer> maxOptional_1  = list.stream().max( Integer::compareTo);
        System.out.println(maxOptional_1.get());

        int min = list.stream().min(Integer::compare).get();
        System.out.println(min);
    }
}
