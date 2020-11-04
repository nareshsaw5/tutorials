package com.example.demo.consumer.mq;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMqConfiguration {

    public static final String MY_QUEUE = "MyQueue";

    @Bean
    public Queue myQueue(){
        return  new Queue(MY_QUEUE);
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }

    @Bean
    public MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(myQueue());
        simpleMessageListenerContainer.setMessageListener(new RabbitMqMessageListener());
        return simpleMessageListenerContainer;
    }

    @Bean Exchange myExchange(){
        return ExchangeBuilder.topicExchange("MyTopicExchange")
                .durable(true)
                .build();
    }

    @Bean
    Binding myBinding(){
       //return new Binding(MY_QUEUE, Binding.DestinationType.QUEUE, "MyTopicExchange", "my-topic-to-my-queue", null);
        return BindingBuilder
                .bind(myQueue())
                .to(myExchange())
                .with("my-topic-to-my-queue")
                .noargs();
    }

}
