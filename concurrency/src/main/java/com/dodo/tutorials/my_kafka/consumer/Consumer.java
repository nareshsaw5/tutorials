package com.dodo.tutorials.my_kafka.consumer;

import com.dodo.tutorials.my_kafka.broker.Message;
import com.dodo.tutorials.my_kafka.broker.Topic;

import java.lang.reflect.Member;

public class Consumer implements Runnable{

    private Topic topic;

    public Consumer(Topic topic){
        this.topic = topic;
    }

    public void run(){
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Message message = topic.consume();
            System.out.println(String.format("consumed %s at offset %s",message.getData(), message.getOffset()));
        }
    }
}
