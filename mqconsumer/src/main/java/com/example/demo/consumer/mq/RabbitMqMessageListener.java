package com.example.demo.consumer.mq;

import org.springframework.amqp.core.Message;

public class RabbitMqMessageListener implements org.springframework.amqp.core.MessageListener {

    @Override public void onMessage(Message message) {

        System.out.println("Thread "+Thread.currentThread().getName());

        System.out.println("Message "+new String(message.getBody()));

    }
}
