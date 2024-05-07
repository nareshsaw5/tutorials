package com.dodo.tutorials.my_kafka;

import com.dodo.tutorials.my_kafka.broker.Topic;
import com.dodo.tutorials.my_kafka.consumer.Consumer;
import com.dodo.tutorials.my_kafka.producer.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Topic test = new Topic("Test", 2);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new Producer(test));
        service.submit(new Consumer(test));
    }
}
