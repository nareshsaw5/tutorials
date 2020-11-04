package com.example.dodo.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemoWithAssignSeek {

    static Logger logger = LoggerFactory.getLogger(ConsumerDemoWithAssignSeek.class);

    public static void main(String[] args) {

        String bootstrapServers  = "127.0.0.1:9092";
        String groupId = "my-fouth-application";
        String topic = "first-topic";

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        //create a consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        //assign and seek are mostly used to replay data or fetch specific data
        //assign
        TopicPartition partitionToReadFrom = new TopicPartition(topic, 0);
        long offsetToReadFrom = 15L;
        consumer.assign(Arrays.asList(partitionToReadFrom));

        //seek
        consumer.seek(partitionToReadFrom, offsetToReadFrom);

        int numberOfMessageToRead = 5;
        boolean keepReading = true;
        int numberOfMessageRead = 0;

        // poll for new data
        while (keepReading){
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord consumerRecord: consumerRecords){
                numberOfMessageRead += numberOfMessageToRead;
                logger.info("Record key "+consumerRecord.key()+ " Value: "+consumerRecord.value());
                logger.info("Record Partition "+consumerRecord.partition()+ " Offset: "+consumerRecord.offset());
                logger.info("---------");
                if(numberOfMessageRead >= numberOfMessageRead){
                    keepReading = false;
                    break;
                }
            }
            logger.info("Exiting application");
        }



    }
}
