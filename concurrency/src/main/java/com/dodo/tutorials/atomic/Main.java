package com.dodo.tutorials.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /**
         * In this case, since we have AtomicInteger, it performs atomic operation as
         */
        InventoryCounter inventoryCounter = new InventoryCounter();
        while(true) {
            MyCounter counter = new MyCounter();
            ExecutorService service = Executors.newFixedThreadPool(10);
            for (int i = 0; i < 1000; i++) {
                service.submit(() -> counter.increase());
            }
            service.shutdown();
            service.awaitTermination(10, TimeUnit.MILLISECONDS);
            System.out.println("Count now " + counter.getCount() + "");
            System.out.println("---------------------");
        }
    }

    public static class DecrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.decrement();
            }
        }
    }

    public static class IncrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.increment();
            }
        }
    }


    private static class InventoryCounter {

        private AtomicInteger items = new AtomicInteger(0);

        public void increment() {
            items.incrementAndGet();
        }

        public void decrement() {
            items.decrementAndGet();
        }

        public int getItems() {
            return items.get();
        }
    }
}

 class MyCounter {
    private int count;
    private Lock lock = new ReentrantLock();

    public void increase(){
            ++count;
    }

    public void increaseWithLock(){
        lock.lock();
        try {
            ++count;
        }finally {
            lock.unlock();
        }
    }
    public int getCount(){
        return this.count;
    }
}

