package com.dodo.tutorials.sharing;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        InventoryCounter counter = new InventoryCounter();
        Thread incrementThread  = new IncrementThread(counter);
        Thread decrementThread = new DecrementThread(counter);
        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();
        System.out.println("We currently have " + counter.getCount() + " items");
    }

    static class DecrementThread extends Thread {
        
        InventoryCounter counter;

        public DecrementThread(InventoryCounter counter) {
            this.counter = counter;
        }
        
        @Override
        public void run(){
            for (int i = 0; i < 1000 ; i++) {
                System.out.println("Decrement " +Thread.currentThread().getName() +" - "+counter.getCount());
                counter.decrement();
            }
        }
    }
    
    static class IncrementThread extends Thread {

        InventoryCounter counter;

        public IncrementThread(InventoryCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run(){
            for (int i = 0; i < 1000; i++) {
                System.out.println("Increment " +Thread.currentThread().getName() +" - "+counter.getCount());
                counter.increment();
            }
        }

    }

    static class InventoryCounter {

        public AtomicInteger getCount() {
            return count;
        }

        private AtomicInteger count = new AtomicInteger();

        public void increment(){
            count.incrementAndGet();
        }

        public void decrement(){
            count.decrementAndGet();
        }

    }
}
