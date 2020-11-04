package com.example.dodo.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerGroupDemo {

    static Logger logger = LoggerFactory.getLogger(ConsumerGroupDemo.class);

    public static void main(String[] args) {

        String bootstrapServers  = "127.0.0.1:9092";
        String groupId = "my-fifth-application";


        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");


        //create a consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        consumer.subscribe(Arrays.asList("first-topic"));

        while (true){
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord consumerRecord: consumerRecords){
                logger.info("Record key "+consumerRecord.key()+ " Value: "+consumerRecord.value());
                logger.info("Record Partition "+consumerRecord.partition()+ " Offset: "+consumerRecord.offset());
                logger.info("---------");
            }
        }



    }
}
