package com.dodo.tutorials.producer_consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Producer_Consumer_3 {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(10);
        ExecutorService service = Executors.newFixedThreadPool(2);
        Random random = new Random();
        // producer
        service.submit( () -> {
            while(true) {
                // create a message
                try {
                    System.out.println("queue "+queue);
                    int message = random.nextInt(1000);
                    System.out.println("new message "+message);
                    boolean isEnqueued = queue.offer(message);
                    if(isEnqueued){
                        System.out.println("Message inserted in the queue");
                    }else {
                        System.out.println("Queue is full");
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // consumer
        service.submit( () -> {
            // consume message
            while(true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("queue in consumer " + queue);
                    int v = queue.poll();
                    System.out.println("consumed " + v);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
