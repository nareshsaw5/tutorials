package com.dodo.learning.stream;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoin = new ForkJoinPool(2);

        List<Integer> list = Stream.iterate(1, (n) -> n+1)
                .limit(100)
                .collect(Collectors.toList());

        long count = forkJoin.submit( () -> {
            System.out.println(Thread.currentThread().getName());
            return list.stream().count();
        }).get();

        System.out.println(count);
    }
}
