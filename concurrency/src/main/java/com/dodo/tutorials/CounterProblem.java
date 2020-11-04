package com.dodo.tutorials;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterProblem {

    public static void main(String[] args) throws InterruptedException {

        /**
         * Demonstrate basic problem of race condition by counter example
         * when the function is not synchronized, there is no guarantee of data read and write
         * I am running multiple threads to increase the counter to get 1000 as result
         * but it never gives 1000 as a result as some of the thread reads and writes in-corrent count
         */
        Counter counter = new Counter();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            service.submit( () -> counter.increment() );
        }
        service.shutdown();
        service.awaitTermination(60, TimeUnit.MILLISECONDS);
        System.out.println(counter.getCount());

    }

    static class Counter {

        private volatile int count;

        public void increment(){
            ++count;
        }

        public int getCount() {
            return count;
        }
    }
}
