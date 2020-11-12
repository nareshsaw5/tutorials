package com.dodo.learning.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterOperation {

    public static void main(String[] args) {
        // filter function takes predicate, Predicate takes input and return boolean, remember this
        List<Integer> evenNumber = Stream.of(1, 2, 3, 4, 5, 6,7, 8, 9, 13)
                .filter( (v) -> v%2 == 0 )
                .collect(Collectors.toList());
        System.out.println(evenNumber);


        // .map function. It takes Function as parameter. Remember that Function takes a parameter and returns a parameter
        // do the square of the even numbers
        List<Integer> squareList = evenNumber.stream().map( n -> n*n ).collect(Collectors.toList());
        System.out.println(squareList);



    }
}
