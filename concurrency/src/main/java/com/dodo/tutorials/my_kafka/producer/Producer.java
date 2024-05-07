package com.dodo.tutorials.my_kafka.producer;

import com.dodo.tutorials.my_kafka.broker.Topic;

import java.util.Random;


public class Producer implements Runnable{

    private Topic topic;
    private Random random = new Random(100);

    public Producer(Topic topic){
        this.topic = topic;
    }
    public void run(){
        String message;
        while(true){
            message = "Message "+random.nextInt(100);
            topic.produce(message);
            System.out.println("produced message "+message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
