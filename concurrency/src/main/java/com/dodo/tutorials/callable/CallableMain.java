package com.dodo.tutorials.callable;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(1);

        Future<String> callableThread = service.submit(new MyCallable());
        System.out.println(callableThread.get());
        service.execute(new MyRunnable());

        service.shutdown();
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
        System.out.println(name + " "+counter.getCount());
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


class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Running thread "+Thread.currentThread().getName());
    }
}

class MyCallable implements Callable {

    @Override
    public String call() throws Exception {
        return "Callable thread "+Thread.currentThread().getName();
    }
}
