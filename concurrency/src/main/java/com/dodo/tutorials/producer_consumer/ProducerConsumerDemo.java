package com.dodo.tutorials.producer_consumer;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerDemo {

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new ArrayBlockingQueue<>(5);
        Random random = new Random();

        ExecutorService service = Executors.newFixedThreadPool(10);
        // producer
        service.submit( () -> {
            while (true){
                try {
                    Integer v = random.nextInt(100);
                    System.out.println("Producing "+v);
                    ((ArrayBlockingQueue<Integer>) queue).offer(v);
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        });

        // consumer
        service.submit( () -> {

            while (true){
                try {
                    Thread.sleep(500);
                    Integer v = queue.poll();
                    System.out.println("Consuming "+v);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        //ser
        service.shutdown();
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

    }

}
