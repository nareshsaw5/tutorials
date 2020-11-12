package com.dodo.tutorials.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ScheduleExecutorMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        Future<String> f = service.schedule(new MyCallable(), 2000, TimeUnit.MILLISECONDS);
        System.out.println(f.get());
        service.shutdown();*/

        List<Integer> list = Arrays.asList(1, 7, 3, 4, 5, 5, 7);
        List<Integer> larger = list.stream().map((n) -> {
            return n * n;
        }).collect(Collectors.toList());

        System.out.println(larger);

    }
}

class MyCallable implements Callable<String> {

    public String call() {
        return "Hello";
    }
}

