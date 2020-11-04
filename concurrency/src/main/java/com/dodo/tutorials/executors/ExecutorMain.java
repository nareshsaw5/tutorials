package com.dodo.tutorials.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain {

    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor(); // creates single worker thread
        executor.execute( () -> System.out.println("Running in separate thread"));
        System.out.println("Main thread");
        ((ExecutorService) executor).shutdown();

    }
}
