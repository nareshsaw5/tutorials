package com.example.demo.consumer.mq;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyQueueBuilder {

    @Bean Queue exampleQueue(){
        return new Queue("Example_1");
    }

    @Bean
    Queue example2ndQueue(){
        return QueueBuilder.durable("Example_2").autoDelete().exclusive().build();
    }
}
