package com.example.dodo.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class ConsumerDemoWithThread {

    static Logger logger = LoggerFactory.getLogger(ConsumerDemoWithThread.class);

    public static void main(String[] args) {
        //TODO, its not shutting down properly. have a look later
        new ConsumerDemoWithThread();

    }

    ConsumerDemoWithThread() {
        run();
    }

    void run() {
        String bootstrapServers = "127.0.0.1:9092";
        String groupId = "my-fouth-application";
        String topic = "my-topic";
        CountDownLatch latch = new CountDownLatch(1);
        ConsumerRunnable consumerRunnable =  new ConsumerRunnable(bootstrapServers, groupId, topic, latch);
        Thread consumerThread = new Thread();
        consumerThread.start();

        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            logger.info("Caught shutdown hook");
            consumerRunnable.shutdown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Application has exited");
        }));

        try {
            latch.await();
        } catch (InterruptedException e) {
            logger.info("Application got interrupted ",e.getMessage());
        }finally {
            logger.info("Application is closing");
        }
    }

    class ConsumerRunnable implements Runnable {

        private CountDownLatch latch;
        KafkaConsumer<String, String> consumer;

        ConsumerRunnable(String bootstrapServers, String groupId, String topic, CountDownLatch latch) {
            this.latch = latch;
            Properties properties = new Properties();
            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

            //create a consumer
            consumer = new KafkaConsumer<String, String>(properties);

            consumer.subscribe(Arrays.asList(topic));
        }

        @Override public void run() {
            try {
                while (true) {
                    ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));
                    for (ConsumerRecord consumerRecord : consumerRecords) {
                        logger.info("Record key " + consumerRecord.key() + " Value: " + consumerRecord.value());
                        logger.info("Record Partition " + consumerRecord.partition() + " Offset: " + consumerRecord
                                .offset());
                        logger.info("---------");
                    }
                }
            } catch (WakeupException e) {
                logger.info("Received shutdown signal ", e.getMessage());
            } finally {
                consumer.close();
                // tell out main code that we are done
                latch.countDown();
            }
        }

        void shutdown() {
            logger.info("Received shutdown signal");
            // a way to interrupt consumer.poll
            consumer.wakeup();
        }
    }
}
