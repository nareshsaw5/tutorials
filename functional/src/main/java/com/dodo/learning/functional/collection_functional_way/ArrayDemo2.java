package com.dodo.learning.functional.collection_functional_way;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayDemo2 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 22, 11, 23, 1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10);
        System.out.println(numbers);
        System.out.println("-----------");
        List<Integer> sorted = numbers.stream().sorted((x, y) -> (x < y) ? -1 : ((x == y) ? 0 : 1))
                .collect(Collectors.toList());
        System.out.println(sorted);
        System.out.println("-----------");

        // another shorter way of sorting
        List<Integer> sorted2 = numbers.stream().sorted( Integer::compareTo).collect(Collectors.toList());
        System.out.println(sorted2);

        // reduce
        int sum = numbers.stream().reduce( (accumulator, number) -> accumulator + number).get();
        System.out.println(sum);
        System.out.println("-----------");

        // multiple with reduce
        int mul = numbers.stream().reduce( (accumulator, number) -> accumulator * number).get();
        System.out.println(mul);
        System.out.println("-----------");

        long c = numbers.stream().min(Integer::compareTo).get();
        System.out.println(c);
        System.out.println("-----------");

        long max = numbers.stream().max(Integer::compareTo).get();
        System.out.println(max);
        System.out.println("-----------");

        List<Integer> reverse = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverse);
        System.out.println("-----------");


    }
}
