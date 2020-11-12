package com.dodo.learning.functional.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer<List<Integer>> consumer = (v) -> System.out.println(v);
        consumer.accept(Arrays.asList(2,3,4,5));
    }
}
