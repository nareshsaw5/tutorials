package com.dodo.learning.stream;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ForkJoinDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(1);

        List<Integer> numbers = Stream.iterate(1, n-> n+1).limit(100).collect(Collectors.toList());

        Long sum = forkJoinPool.submit ( () -> {
            return numbers.stream().count();
        }).get();
        System.out.println(sum);
    }
}
