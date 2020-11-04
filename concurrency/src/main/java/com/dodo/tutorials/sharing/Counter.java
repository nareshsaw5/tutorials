package com.dodo.tutorials.sharing;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    int count = 0;

    public void increment() {
        count++;
        System.out.println(count);
    }

    public void decrement() {
        count--;
        System.out.println(count);
    }

    public int getCount() {
        return count;
    }

    static class IncrementThread extends Thread {

        private Counter counter;

        public IncrementThread(Counter counter) {
            this.counter = counter;
        }

        @Override public void run() {
            counter.increment();
        }
    }

    static class DecrementThread extends Thread {

        private Counter counter;

        public DecrementThread(Counter counter) {
            this.counter = counter;
        }

        @Override public void run() {
            counter.decrement();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        for (int i = 0; i < 10000; i++) {
            new IncrementThread(counter).start();
            new DecrementThread(counter).start();
        }
    }

    static class AtomicCounter {

        private AtomicInteger counter = new AtomicInteger();

        public void increment() {
            int count = counter.incrementAndGet();
            System.out.println(count);
        }

        public void decrement() {
            int count = counter.decrementAndGet();
            System.out.println(count);
        }
    }
}
