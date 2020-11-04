package com.dodo.tutorials.callable;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(100);
        Counter counter = new Counter();

        List<Callable<String>> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add(new TestCallable(counter));
        }

        service.invokeAll(list);

        for (int i = 0; i < 1000; i++) {

            service.submit( () -> counter.increment());

        }

        service.shutdown();
        System.out.println(counter.getCount());
    }


}

class TestCallable implements Callable<String>{

    private Counter counter;

    public TestCallable(Counter counter) {
        this.counter = counter;
    }

    @Override public String call() {
        counter.increment();
        String name = Thread.currentThread().getName();
        System.out.println(name);
        return name;
    }
}

class Counter {

    private int count;

    public void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
