package com.dodo.tutorials.producer_consumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
        Thread producer = new Producer(queue);
        Thread consumer = new Consumer(queue);
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

    }


    static class Producer extends Thread{

        private Queue<Integer> queue;

        public Producer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run(){
            while (true){
                Random random = new Random();
                Integer v = random.nextInt(100);
                System.out.println("producing "+v);
                queue.offer(v);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {

        private Queue<Integer> queue;

        public Consumer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run(){
            while (true){
                Integer v = queue.poll();
                System.out.println("consuming "+v);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
