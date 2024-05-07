package com.dodo.tutorials.producer_consumer;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Producer_Consumer_2 {

    public static void main(String[] args) {

        ArrayBlockingQueue queue = new ArrayBlockingQueue(1);
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);
        ExecutorService service  = Executors.newFixedThreadPool(2);
        service.submit(p);
        service.submit(c);

    }
}

class Producer implements Runnable {

    private ArrayBlockingQueue<Integer> queue;
    Random random = new Random();
    Producer(ArrayBlockingQueue queue){
        this.queue = queue;
    }
    public void run(){
        while(true){
            System.out.println("queue " + queue);
            int v = random.nextInt(1000);
            System.out.println("Producing value: "+v);
            boolean isInserted = queue.offer(v);
            System.out.println("isEnqueued "+isInserted);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable {

    private ArrayBlockingQueue queue;
    Consumer(ArrayBlockingQueue queue){
        this.queue = queue;
    }
    public void run(){
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("queue " + queue);
                int v = (Integer) queue.poll();
                System.out.println("Consumed " + v);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
