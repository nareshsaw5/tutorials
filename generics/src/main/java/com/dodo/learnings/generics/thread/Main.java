package com.dodo.learnings.generics.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newScheduledThreadPool(5);
        Counter counter = new Counter();
        for (int i = 0; i <1000 ; i++) {
            service.submit( () -> {
                counter.increment();
            });
        }
        System.out.println(counter.getCount());
        service.shutdown();
    }
}


class Counter {

    int count;

    public void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
