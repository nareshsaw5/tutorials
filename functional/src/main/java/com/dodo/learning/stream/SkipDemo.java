package com.dodo.learning.stream;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class SkipDemo {

    public static void main(String[] args) {
        List<Integer> skipped = List.of(1,2,3,4,5,6,7,8,9,10)
                .stream()
                .skip(1)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(skipped);

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
    }
}
