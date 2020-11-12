package com.dodo.learning.stream;

import java.util.stream.Stream;

public class ReduceOperation {

    public static void main(String[] args) {
        int sum = Stream.of(1,2,3)
                .reduce(0, (accumulator, v) -> accumulator+v )
                .intValue();

        // reduce function is good for computing sum, multiplication, min, max etc

        int multiple = Stream.of(1, 2, 3, 4)
                .reduce(1,  (accumulator, v) -> accumulator * v).intValue();
        System.out.println(multiple);

        int minValue = Stream.of(1,2,3,4,5,6)
                .reduce( 1, (accumulator, v) -> accumulator > v ? v : accumulator).intValue();
        System.out.println(minValue);

        int maxValue = Stream.of(10, 2, 3, 4, 6)
                .reduce(0, (accumulator, v) -> v < accumulator ? accumulator: v);
        System.out.println(maxValue);

        int fib = Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25)
                .reduce(1, (accumulator, v) -> accumulator *v).intValue();
        System.out.println(fib);
    }
}
